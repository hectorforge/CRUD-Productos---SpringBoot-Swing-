package com.example.demo.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.GridLayout;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

public class HomeFrm extends JFrame {

    private final ProductService productService;
    private int currentPage = 0;
    private int pageSize = 10;
    
    long totalItems;
    int totalPages;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Dependency inyections
     */
    public HomeFrm(ProductService ps) {
        this.productService = ps;
        initUI();
    }

    /**
     * GUI 
     */
    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        setTitle("CRUD Productos - Spring + Swing");

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("CRUD Productos (Spring + Swing)", SwingConstants.CENTER);
        lblTitle.setFont(lblTitle.getFont().deriveFont(16f));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{
                "ID", "Name", "Description", "Price", "Stock", "Active"
        }, 0);

        table = new JTable(model);
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Agregar");
        JButton btnEdit = new JButton("Editar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnRefresh = new JButton("Actualizar lista");
        JButton btnPrev = new JButton("Anterior");
        JButton btnNext = new JButton("Siguiente");

        panelButtons.add(btnAdd);
        panelButtons.add(btnEdit);
        panelButtons.add(btnDelete);
        panelButtons.add(btnRefresh);
        panelButtons.add(btnPrev);
        panelButtons.add(btnNext);

        contentPane.add(panelButtons, BorderLayout.SOUTH);

        btnAdd.addActionListener(this::onAdd);
        btnEdit.addActionListener(this::onEdit);
        btnDelete.addActionListener(this::onDelete);
        btnRefresh.addActionListener(e -> cargarDatos());
        
        btnPrev.addActionListener(e -> setPage(currentPage - 1));
        btnNext.addActionListener(e -> setPage(currentPage + 1));


        cargarDatos();
    }

    private void setPage(int page) {
        currentPage = Math.max(0, Math.min(page, totalPages - 1));
        cargarDatos();
    }
    
    private void cargarDatos() {
        model.setRowCount(0);
        
        Page<Product> page = productService.getAll(
            PageRequest.of(currentPage, pageSize, Sort.by("id").ascending())
        );
        
        totalPages= page.getTotalPages();
        totalItems = page.getTotalElements();

        for (Product p : page.getContent()) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getPrice(),
                    p.getStock(),
                    p.isActivo()
            });
        }
        
        setTitle("CRUD Productos - Página " + (page.getNumber() + 1) 
                 + " de " + page.getTotalPages());
    }

    private void onAdd(ActionEvent e) {
        Product p = showProductDialog(null);
        if (p != null) {
            String msg = productService.create(p);
            JOptionPane.showMessageDialog(this, msg);
            cargarDatos();
        }
    }

    private void onEdit(ActionEvent e) {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar");
            return;
        }

        Long id = (Long) model.getValueAt(row, 0);
        Product existing = productService.getById(id);
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "El producto ya no existe");
            cargarDatos();
            return;
        }

        Product updated = showProductDialog(existing);
        if (updated != null) {
            String msg = productService.update(id, updated);
            JOptionPane.showMessageDialog(this, msg);
            cargarDatos();
        }
    }

    private void onDelete(ActionEvent e) {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar");
            return;
        }

        Long id = (Long) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el producto?", 
                                                    "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String msg = productService.delete(id);
            JOptionPane.showMessageDialog(this, msg);
            cargarDatos();
        }
    }

    /**
     * Dialog for Create or alter product
     */
    private Product showProductDialog(Product existing) {
        JTextField txtName = new JTextField();
        JTextField txtDescription = new JTextField();
        JTextField txtPrice = new JTextField();
        JTextField txtStock = new JTextField();
        JCheckBox chkActive = new JCheckBox("Activo");

        if (existing != null) {
            txtName.setText(existing.getName());
            txtDescription.setText(existing.getDescription());
            txtPrice.setText(String.valueOf(existing.getPrice()));
            txtStock.setText(String.valueOf(existing.getStock()));
            chkActive.setSelected(existing.isActivo());
        }

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtName);
        panel.add(new JLabel("Descripción:"));
        panel.add(txtDescription);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrice);
        panel.add(new JLabel("Stock:"));
        panel.add(txtStock);
        panel.add(chkActive);

        int result = JOptionPane.showConfirmDialog(this, panel,
                (existing == null ? "Nuevo Producto" : "Editar Producto"),
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                return Product.builder()
                        .name(txtName.getText())
                        .description(txtDescription.getText())
                        .price(Double.parseDouble(txtPrice.getText()))
                        .stock(Integer.parseInt(txtStock.getText()))
                        .activo(chkActive.isSelected())
                        .build();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage());
            }
        }
        return null;
    }
}

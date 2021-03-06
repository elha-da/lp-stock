package fr.acpi.stock.view;

import fr.acpi.stock.AppData;
import fr.acpi.stock.product.ProductController;
import fr.acpi.stock.product.SalesController;
import fr.acpi.stock.product.StockController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends JFrame implements ActionListener, WindowListener {
	private JButton btnDisplay;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnPurchase;
	private JButton btnSale;
	private JButton btnExit;

	ProductController _productCtrl;
	SalesController _salesCtrl;
	StockController _stockCtrl;

	public MainWindow(ProductController productCtrl, SalesController salesCtrl, StockController stockCtrl) {
		this._productCtrl = productCtrl;
		this._salesCtrl = salesCtrl;
		this._stockCtrl = stockCtrl;

		this.setTitle("Gestion de stock");
		this.setBounds(500, 500, 320, 250);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		JPanel pnlDisplay = new JPanel();
		JPanel pnlNewDelete = new JPanel();
		JPanel pnlPurchaseSale = new JPanel();
		JPanel pnlExit = new JPanel();

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		this.btnDisplay = new JButton("Quantités en stock");
		this.btnNew = new JButton("Nouveau produit");
		this.btnDelete = new JButton("Supprimer produit");
		this.btnPurchase = new JButton("Acheter produit");
		this.btnSale = new JButton("Vendre produit");
		this.btnExit = new JButton("Quitter");

		this.btnDisplay.addActionListener(this);
		this.btnNew.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnPurchase.addActionListener(this);
		this.btnSale.addActionListener(this);
		this.btnExit.addActionListener(this);

		pnlDisplay.add(this.btnDisplay);
		pnlNewDelete.add(this.btnNew);
		pnlNewDelete.add(this.btnDelete);
		pnlPurchaseSale.add(this.btnPurchase);
		pnlPurchaseSale.add(this.btnSale);
		pnlExit.add(this.btnExit);

		contentPane.add(pnlDisplay);
		contentPane.add(pnlNewDelete);
		contentPane.add(pnlPurchaseSale);
		contentPane.add(pnlExit);

		this.addWindowListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] names = AppData.Catalog.productsNames();
		Object source = e.getSource();

		if (source == this.btnDisplay) {
			new DisplayWindow(this._stockCtrl);
			System.out.println("Display stock");
		}
		else if (source == this.btnNew) {
			new NewWindow(this._productCtrl);
			System.out.println("New product");
		}
		else if (source == this.btnDelete) {
			new DeleteWindow(names, this._productCtrl);
			System.out.println("Delete product");
		}
		else if (source == this.btnPurchase) {
			new PurchaseWindow(names, this._salesCtrl);
			System.out.println("Purchase a product");
		}
		else if (source == this.btnSale) {
			new SaleWindow(names, this._salesCtrl);
			System.out.println("Sell a product");
		}
		else if (source == this.btnExit) {
			System.out.println("Exit");
			System.exit(0);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}

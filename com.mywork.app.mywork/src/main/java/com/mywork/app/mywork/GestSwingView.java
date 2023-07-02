package com.mywork.app.mywork;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultListModel;


public class GestSwingView extends JFrame implements GestView{

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField publicText;
	private JTextField privateText;
	private JTextField copiesText;
	private JButton btnAdd;
	private JList list;
	private JScrollPane scrollPane;
	private JButton btnRemove;
	private JButton btnBuy;
	private JLabel lblNewLabel_4;
	
	private JList<Book> listBooks;
	private DefaultListModel<Book> listBooksModel;
	DefaultListModel<Book> getListBooksModel() {
        return listBooksModel;
    }
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestSwingView frame = new GestSwingView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestSwingView() {
		listBooksModel = new DefaultListModel<>();
		listBooks = new JList<>(listBooksModel);
		setTitle("Gestion View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 88, 0, 49, -35, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 31, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		KeyAdapter btnAddEnabler = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnAdd.setEnabled(!nameText.getText().trim().isEmpty() && !privateText.getText().trim().isEmpty() && !publicText.getText().trim().isEmpty() && !copiesText.getText().trim().isEmpty());
			}
		};
		nameText.addKeyListener(btnAddEnabler);
		privateText.addKeyListener(btnAddEnabler);
		publicText.addKeyListener(btnAddEnabler);
		copiesText.addKeyListener(btnAddEnabler);
		
		
			
		nameText.setName("nameTextBox");
		GridBagConstraints gbc_nameText = new GridBagConstraints();
		gbc_nameText.gridwidth = 6;
		gbc_nameText.insets = new Insets(0, 0, 5, 0);
		gbc_nameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameText.gridx = 1;
		gbc_nameText.gridy = 0;
		contentPane.add(nameText, gbc_nameText);
		nameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Public Price");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		publicText = new JTextField();
		publicText.setName("publicPriceTextBox\r\n");
		GridBagConstraints gbc_publicText = new GridBagConstraints();
		gbc_publicText.insets = new Insets(0, 0, 5, 5);
		gbc_publicText.fill = GridBagConstraints.HORIZONTAL;
		gbc_publicText.gridx = 1;
		gbc_publicText.gridy = 1;
		contentPane.add(publicText, gbc_publicText);
		publicText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Private Price");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		privateText = new JTextField();
		privateText.setName("PrivatePriceTextBox");
		GridBagConstraints gbc_privateText = new GridBagConstraints();
		gbc_privateText.gridwidth = 2;
		gbc_privateText.insets = new Insets(0, 0, 5, 5);
		gbc_privateText.fill = GridBagConstraints.HORIZONTAL;
		gbc_privateText.gridx = 3;
		gbc_privateText.gridy = 1;
		contentPane.add(privateText, gbc_privateText);
		privateText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numberOfCopies");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 1;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		copiesText = new JTextField();
		copiesText.setName("copiesTextField");
		GridBagConstraints gbc_copiesText = new GridBagConstraints();
		gbc_copiesText.insets = new Insets(0, 0, 5, 0);
		gbc_copiesText.fill = GridBagConstraints.HORIZONTAL;
		gbc_copiesText.gridx = 6;
		gbc_copiesText.gridy = 1;
		contentPane.add(copiesText, gbc_copiesText);
		copiesText.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridwidth = 7;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 2;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnRemove.setEnabled(list.getSelectedIndex() != -1);
				btnBuy.setEnabled(list.getSelectedIndex() != -1);
			}
		});
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setName("bookList");
		
		btnRemove = new JButton("Remove");
		btnRemove.setEnabled(false);
		btnRemove.setName("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 7;
		contentPane.add(btnRemove, gbc_btnRemove);
		
		btnBuy = new JButton("Buy");
		btnBuy.setEnabled(false);
		btnBuy.setName("buyButton");
		GridBagConstraints gbc_btnBuy = new GridBagConstraints();
		gbc_btnBuy.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuy.gridx = 5;
		gbc_btnBuy.gridy = 7;
		contentPane.add(btnBuy, gbc_btnBuy);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setName("errorLabel");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 6;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
	}

	@Override
	public BankAccount getBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> getInventory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean newBookInInventory(Book newBook) {
		listBooksModel.addElement(newBook);
		if(listBooksModel.contains(newBook)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addingMoreCopiesOfABook(Book book, int copies) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBookFromInventory(Book book) {
		listBooksModel.removeElement(book);
		if(listBooksModel.contains(book)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean someoneBuysABook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}

package view;

import controller.FilmController;
import model.Film;
import model.Tiket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private FilmController filmController;

    public MainFrame() {
        filmController = new FilmController();

        // Tambah beberapa film ke daftar
        filmController.tambahFilm(new Film("Avengers: Endgame", "Action", 50000));
        filmController.tambahFilm(new Film("Frozen II", "Animation", 40000));
        filmController.tambahFilm(new Film("Joker", "Drama", 45000));

        setTitle("Sistem Pemesanan Tiket Bioskop");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Utama
        JPanel panel = new JPanel(new BorderLayout());

        // Panel Pilihan Film
        JComboBox<Film> comboFilm = new JComboBox<>(filmController.getDaftarFilm().toArray(new Film[0]));
        JLabel labelJumlah = new JLabel("Jumlah Tiket:");
        JTextField fieldJumlah = new JTextField();
        JButton buttonPesan = new JButton("Pesan Tiket");

        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.add(new JLabel("Pilih Film:"));
        panelInput.add(comboFilm);
        panelInput.add(labelJumlah);
        panelInput.add(fieldJumlah);
        panelInput.add(new JLabel());
        panelInput.add(buttonPesan);

        // Panel Output
        JTextArea areaOutput = new JTextArea();
        areaOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaOutput);

        panel.add(panelInput, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Action Listener
        buttonPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Film filmDipilih = (Film) comboFilm.getSelectedItem();
                    int jumlah = Integer.parseInt(fieldJumlah.getText());

                    if (jumlah > 0) {
                        Tiket tiket = new Tiket(filmDipilih, jumlah);
                        areaOutput.setText("Tiket Berhasil Dipesan!\n\n" + tiket.getDetail());
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah tiket harus lebih dari 0!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan jumlah tiket yang valid!");
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

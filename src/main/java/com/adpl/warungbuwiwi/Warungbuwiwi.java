package com.adpl.warungbuwiwi;

import com.adpl.warungbuwiwi.controller.StokController;
import com.adpl.warungbuwiwi.model.IStokRepository;
import com.adpl.warungbuwiwi.model.StokRepository;
import com.adpl.warungbuwiwi.view.StokView;

import javax.swing.SwingUtilities;

public class Warungbuwiwi {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IStokRepository repository = new StokRepository();
            StokView view = new StokView();
            new StokController(repository, view);
            view.setVisible(true);
        });
    }
}
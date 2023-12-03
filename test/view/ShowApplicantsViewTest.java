package view;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackController;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;
import org.junit.jupiter.api.Test;
import use_case.back.BackInputBoundary;
import use_case.deleteApplicants.DeleteApplicantsInputBoundary;
import use_case.deleteApplicants.DeleteApplicantsInputData;
import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;
import use_case.resumeParsing.ResumeParsingInputBoundary;
import use_case.resumeParsing.ResumeParsingInputData;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.junit.jupiter.api.Assertions.*;

class ShowApplicantsViewTest {
    @Test
    void clickingButtons(){
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Making the fake interactors to initialize the controllers

        FilterInputBoundary filterInteractor = new FilterInputBoundary() {
            @Override
            public void execute(FilterInputData inputData) {

            }
        };

        DeleteApplicantsInputBoundary deleteInteractor = new DeleteApplicantsInputBoundary() {
            @Override
            public void execute(DeleteApplicantsInputData inputData) {

            }
        };

        ShowHireApplicantPageInputBoundary showHireApplicantPageInteractor = new ShowHireApplicantPageInputBoundary() {
            @Override
            public void execute(ShowHireApplicantPageInputData applicantID) {

            }
        };

        ResumeParsingInputBoundary resumeParsingInteractor = new ResumeParsingInputBoundary() {
            @Override
            public void execute(ResumeParsingInputData inputData) {

            }
        };

        BackInputBoundary backInputBoundary = new BackInputBoundary() {
            @Override
            public void execute() {

            }
        };

        // Making the fake controllers to initialize the view

        FilterController filterController = new FilterController(filterInteractor);
        DeleteApplicantsController deleteApplicantsController = new DeleteApplicantsController(deleteInteractor);
        ShowHireApplicantPageController showHireApplicantPageController = new ShowHireApplicantPageController(showHireApplicantPageInteractor);
        ResumeParsingController resumeParsingController = new ResumeParsingController(resumeParsingInteractor);
        BackController backController = new BackController(backInputBoundary);

        // Making the testing view

        ShowApplicantsView view = new ShowApplicantsView(viewManagerModel, showApplicantsViewModel, filterController,
                deleteApplicantsController, showHireApplicantPageController, resumeParsingController, backController);

        // Referencing the buttons

        JButton hireApplicantButton = view.hireApplicant;
        JButton deleteApplicantsButton = view.deleteApplicants;
        JButton uploadFilesButton = view.uploadFiles;
        JButton applyFiltersButton = view.applyFilters;
        JButton backButtonButton = view.backButton;

        // Referencing the textfields

        JTextField hireApplicant_in = view.hireApplicant_in;
        JTextField deleteApplicants_in = view.deleteApplicants_in;
        JTextField uploadFiles_in = view.uploadFiles_in;
        JTextField applyFilters_in_skills = view.applyFilters_in_skills;
        JTextField applyFilters_in_date = view.applyFilters_in_date;
        JTextField uploadPosition_in = view.uploadPosition_in;

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        hireApplicantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals(hireApplicantButton, e.getSource());
            }
        }
        );
        deleteApplicantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals(deleteApplicantsButton, e.getSource());
            }
        });
        uploadFilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals(uploadFilesButton, e.getSource());
            }
        });
        applyFiltersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals(applyFiltersButton, e.getSource());
            }
        });
        backButtonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assertEquals(backButtonButton, e.getSource());
            }
        });

        hireApplicantButton.doClick();
        deleteApplicantsButton.doClick();
        uploadFilesButton.doClick();
        applyFiltersButton.doClick();
        backButtonButton.doClick();

        hireApplicant_in.addKeyListener(keyListener);
        deleteApplicants_in.addKeyListener(keyListener);
        uploadFiles_in.addKeyListener(keyListener);
        applyFilters_in_skills.addKeyListener(keyListener);
        applyFilters_in_date.addKeyListener(keyListener);
        uploadPosition_in.addKeyListener(keyListener);

        char keyChar = 'A';
        int keyCode = KeyEvent.VK_UNDEFINED;

        keyListener.keyTyped(new KeyEvent(hireApplicant_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(hireApplicant_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(hireApplicant_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));

        keyListener.keyTyped(new KeyEvent(deleteApplicants_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(deleteApplicants_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(deleteApplicants_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));

        keyListener.keyTyped(new KeyEvent(uploadFiles_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(uploadFiles_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(uploadFiles_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));

        keyListener.keyTyped(new KeyEvent(applyFilters_in_date, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(applyFilters_in_date, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(applyFilters_in_date, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));

        keyListener.keyTyped(new KeyEvent(applyFilters_in_skills, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(applyFilters_in_skills, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(applyFilters_in_skills, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));

        keyListener.keyTyped(new KeyEvent(uploadPosition_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyPressed(new KeyEvent(uploadPosition_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        keyListener.keyReleased(new KeyEvent(uploadPosition_in, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
    }
}
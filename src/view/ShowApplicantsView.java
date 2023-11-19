package view;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowApplicantsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Show Applicants";
    private final ShowApplicantsViewModel showApplicantsViewModel;
    private final ViewManagerModel viewManagerModel;
    private final FilterController filterController;
    private final DeleteApplicantsController deleteApplicantsController;
    private final ShowHireApplicantPageController showHireApplicantPageController;
    private final ResumeParsingController resumeParsingController;

    private final JButton hireApplicant;
    private final JButton deleteApplicants;
    private final JButton uploadFiles;
    private final JButton applyFilters;
    private final JTextField hireApplicant_in = new JTextField(10);
    private final JTextField deleteApplicants_in = new JTextField(10);
    private final JTextField uploadFiles_in = new JTextField(10);
    private final JTextField applyFilters_in_skills = new JTextField(10);
    private final JTextField applyFilters_in_date = new JTextField(10);
    private final JTextField uploadPosition_in = new JTextField(10);

    public ShowApplicantsView(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel,
                              FilterController filterController, DeleteApplicantsController deleteApplicantsController,
                              ShowHireApplicantPageController showHireApplicantPageController,
                              ResumeParsingController resumeParsingController) {
        this.deleteApplicantsController = deleteApplicantsController;
        this.viewManagerModel = viewManagerModel;
        this.filterController = filterController;
        this.showApplicantsViewModel = showApplicantsViewModel;
        this.showHireApplicantPageController = showHireApplicantPageController;
        this.resumeParsingController = resumeParsingController;

        showApplicantsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ShowApplicantsViewModel.TITLE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel applyFilters_info_date = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.FILTER_BY_UPLOAD_DATE_LABEL), applyFilters_in_date);
        LabelTextPanel applyFilters_info_skills = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.FILTER_BY_SKILL), applyFilters_in_skills);
        LabelTextPanel hireApplicant_info = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.HIRING_TEXT_LABEL), hireApplicant_in);
        LabelTextPanel deleteApplicants_info = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.DELETE_TEXT_LABEL), deleteApplicants_in);
        LabelTextPanel uploadFiles_info = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.UPLOAD_TEXT_LABEL), uploadFiles_in);
        LabelTextPanel uploadPosition_info = new LabelTextPanel(
                new JLabel(ShowApplicantsViewModel.UPLOAD_POSITION_LABEL), uploadPosition_in);

        JPanel buttons = new JPanel();

        hireApplicant = new JButton(ShowApplicantsViewModel.SHOW_HIRE_PAGE_BUTTON_LABEL);
        buttons.add(hireApplicant);
        deleteApplicants = new JButton(ShowApplicantsViewModel.DELETE_BUTTON_LABEL);
        buttons.add(deleteApplicants);
        uploadFiles = new JButton(ShowApplicantsViewModel.RESUME_PARSER_BUTTON_LABEL);
        buttons.add(uploadFiles);
        applyFilters = new JButton(ShowApplicantsViewModel.APPLY_FILTERS_ON_APPLICANTS_BUTTON_LABEL);
        buttons.add(applyFilters);

        hireApplicant.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(hireApplicant)) {
                            ShowApplicantsState currentState = showApplicantsViewModel.getState();

                            showHireApplicantPageController.execute(
                                    // Would get this from State
                                    currentState.getApplicantToHire()
                            );
                        }
                    }
                }
        );

        deleteApplicants.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteApplicants)){
                            ShowApplicantsState currentState = showApplicantsViewModel.getState();

                            deleteApplicantsController.execute(
                                    // Would get this from State
                                    currentState.getApplicantsToDelete()
                            );
                        }
                    }
                }
        );

        uploadFiles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(uploadFiles)){
                            ShowApplicantsState currentState = showApplicantsViewModel.getState();

                            resumeParsingController.execute(
                                    // Would get this from State
                                    currentState.getFilesToUpload(),
                                    currentState.getPositionToUpload()
                            );
                        }
                    }
                }
        );

        deleteApplicants.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteApplicants)){
                            ShowApplicantsState currentState = showApplicantsViewModel.getState();

                            showHireApplicantPageController.execute(
                                    // Would get this from State
                                    currentState.applicantsToDelete()
                            );
                        }
                    }
                }
        );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

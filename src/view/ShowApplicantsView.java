package view;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    JLabel applicants;
    private final JButton hireApplicant;
    private final JButton deleteApplicants;
    private final JButton uploadFiles;
    private final JButton applyFilters;
    private final JTextField hireApplicant_in = new JTextField(10);
    private final JTextField deleteApplicants_in = new JTextField(10);
    private final JTextField uploadFiles_in = new JTextField(50);
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
//                                    currentState.getFilesToUpload(),
                                    hireApplicant_in.getText(),
                                    currentState.getPositionToUpload()
                            );
                        }
                    }
                }
        );

        applyFilters.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(applyFilters)){
                            ShowApplicantsState currentState = showApplicantsViewModel.getState();

                            filterController.execute(
                                    // Would get this from State
                                    currentState.getDateToFilter(),
                                    currentState.getSkillToFilter()
                            );
                        }
                    }
                }
        );

        // Making the actionListener for the TextBoxes
        // hireApplicant_in, deleteApplicants_in, uploadFiles_in, applyFilters_in_skills, applyFilters_in_date, uploadPosition_in

        hireApplicant_in.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = hireApplicant_in.getText() + e.getKeyChar();
                        currentState.setApplicantToHire(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        deleteApplicants_in.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = deleteApplicants_in.getText() + e.getKeyChar();
                        currentState.setApplicantsToDelete(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        uploadFiles_in.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = uploadFiles_in.getText() + e.getKeyChar();
                        currentState.setFilesToUpload(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        applyFilters_in_skills.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = applyFilters_in_skills.getText() + e.getKeyChar();
                        currentState.setSkillToFilter(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        applyFilters_in_date.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = applyFilters_in_date.getText() + e.getKeyChar();
                        currentState.setDateToFilter(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        uploadPosition_in.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowApplicantsState currentState = showApplicantsViewModel.getState();
                        String text = uploadPosition_in.getText() + e.getKeyChar();
                        currentState.setPositionToUpload(text);
                        showApplicantsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel head = new JLabel("List of Applicants: ");

        applicants = new JLabel();

        // adding things to the view
        // hireApplicant_in, deleteApplicants_in, uploadFiles_in, applyFilters_in_skills, applyFilters_in_date, uploadPosition_in
        this.add(title);
        this.add(hireApplicant_info);
        this.add(deleteApplicants_info);
        this.add(uploadFiles_info);
        this.add(applyFilters_info_date);
        this.add(applyFilters_info_date);
        this.add(uploadPosition_info);
        this.add(buttons);
        this.add(head);
        this.add(applicants);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
//        JOptionPane.showConfirmDialog(this, )
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ShowApplicantsState state = showApplicantsViewModel.getState();
        String applicantsToDisplay = state.getApplicantsToDisplay();
        applicants.setText(applicantsToDisplay);
    }
}

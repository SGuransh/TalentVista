package use_case.back;

public class BackInteractor implements BackInputBoundary{
    final BackOutputBoundary backPresenter;

    public BackInteractor(BackOutputBoundary backPresenter) {
        this.backPresenter = backPresenter;
    }

    @Override
    public void execute() {
        backPresenter.prepareSuccessView();
    }
}

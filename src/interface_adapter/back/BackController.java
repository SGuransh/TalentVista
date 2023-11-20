package interface_adapter.back;

import use_case.back.BackInputBoundary;

public class BackController {
    final BackInputBoundary backInteractor;

    public BackController(BackInputBoundary backInteractor) {
        this.backInteractor = backInteractor;
    }
    public void execute(){backInteractor.execute();}
}

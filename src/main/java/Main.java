import backend.BackEndServer;
import datatransfer.PositionData;
import frontend.FrontEndApplication;

public class Main {
    private static final int GROUND_WIDTH = 700;
    private static final int GROUND_HEIGHT = 440;
    private static final int PANALTY_COURT_WIDTH = 110;
    private static final int PANALTY_COURT_HEIGHT = 260;
    private static final int GALL_COURT_WIDTH = 40;
    private static final int GALL_COURT_HEIGHT = 120;
    private static final int CENTER_CIRCLE_RADIOUS = 60;
    private static final int DOT_RADIOUS = 5;

    private static FrontEndApplication frontEndApplication;
    private static BackEndServer backEndServer;

    public static void main(String[] args) {
        //initiate frontend and back end
        backEndServer = new BackEndServer(GROUND_WIDTH, GROUND_HEIGHT);
        backEndServer.initServer();
        frontEndApplication = new FrontEndApplication(GROUND_WIDTH, GROUND_HEIGHT,
                PANALTY_COURT_WIDTH, PANALTY_COURT_HEIGHT,
                GALL_COURT_WIDTH, GALL_COURT_HEIGHT,
                CENTER_CIRCLE_RADIOUS, DOT_RADIOUS,
                "FooBall Game Simulation");

        //run system
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (!backEndServer.isGameOver()) {
                    //front end is running for a while
                    frontEndApplication.redrawGUI();
                    //backend is running for a while
                    backEndServer.processData();
                    //backend server sends data to frontend application
                    PositionData positionData = backEndServer.sendNewCoordinates();
                    frontEndApplication.updateLocations(positionData);
                }
            }
        });
        t.start();
    }
}

import com.financial.cleaningrobot.api.Position;
import com.financial.cleaningrobot.api.RobotApi;
import com.financial.cleaningrobot.api.RobotControl;

/**
 * Robot controller implementation
 */
public class Challenge {

    /**
     * The main entry point.
     * Don't change the code, besides the file path of the room layout.
     */
    public static void main(String[] args) throws Exception {
        RobotControl rc = new RobotControl("../resources/room-layout-1.txt");
        RobotApi api = rc.getRobotApi();
        cleanRooms(api);
        rc.evaluateResult();
    }

    /**
     * Add your implementation here.
     */
    private static void cleanRooms(RobotApi api) {
        Position initialPosition = api.getPosition();
        clean(api, initialPosition);

    }

    static void clean(RobotApi api, Position previous) {
        if(api.isBarrierAhead() || api.getPositionAhead().equals(previous)){
            api.turnRight();
        } else {
            api.move();
            clean(api, api.getPosition());
        }
    }
}

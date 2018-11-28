package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Drive")
//what is poppin
public class Drive extends LinearOpMode {
    @Override
    public void runOpMode() {
        RightTriggerResponseType rightTriggerResponseType = RightTriggerResponseType.RIGHT_SIDE_POWERED_POSITIVE;
        LeftTriggerResponseType leftTriggerResponseType = LeftTriggerResponseType.LEFT_SIDE_POWERED_POSITIVE;

        Robot robot = new Robot(hardwareMap);

        waitForStart();
        robot.runtime.reset();

        while (opModeIsActive()) {
            robot.emptyMotors();
            robot.respondToRightTrigger(rightTriggerResponseType, gamepad1.right_trigger);
            robot.respondToLeftTrigger(leftTriggerResponseType, gamepad1.left_trigger);

            telemetry.addData("Runtime: ", robot.runtime);
            telemetry.update();
        }
    }
}

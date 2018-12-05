package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Motor Test")
public class MotorTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor frontLeftDrive;
        DcMotor frontRightDrive;
        DcMotor backLeftDrive;
        DcMotor backRightDrive;

        DcMotor ScoopMotor;

        frontLeftDrive = hardwareMap.dcMotor.get("front_left_drive");
        backLeftDrive = hardwareMap.dcMotor.get("back_left_drive");
        frontRightDrive = hardwareMap.dcMotor.get("front_right_drive");
        backRightDrive = hardwareMap.dcMotor.get("back_right_drive");
        ScoopMotor = hardwareMap.dcMotor.get("scoop_motor");

        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ScoopMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        ScoopMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
        ScoopMotor.setPower(0);

        double fwdpct, stfpct, trnpct;
        double fwdcmd, stfcmd, trncmd;
        double fwdstk, stfstk, trnstk;
        fwdpct = 0.4; stfpct = 0.25; trnpct = 0.35;

        waitForStart();

        while (opModeIsActive()) {
            frontLeftDrive.setPower(0);
            backLeftDrive.setPower(0);
            frontRightDrive.setPower(0);
            backRightDrive.setPower(0);

            //sum joysticks and limit range from -1 to +1
            fwdstk = Math.max(-1,Math.min(1,gamepad1.left_stick_y + gamepad1.right_stick_y));
            stfstk = Math.max(-1,Math.min(1,gamepad1.left_stick_x + gamepad1.right_stick_x));

            //combine tiggers and limit range from -1 to +1
            trnstk = Math.max(-1,Math.min(1,gamepad1.right_trigger - gamepad1.left_trigger));

            //multiply stick inputs by maximum rates to get commands
            fwdcmd = fwdstk * fwdpct;
            stfcmd = stfstk * stfpct;
            trncmd = trnstk * trnpct;

            //scoop motor controls
            if (gamepad1.a) {ScoopMotor.setPower(-0.5);} else if (gamepad1.y) {ScoopMotor.setPower(0.5);} else {ScoopMotor.setPower(0);}

            //compute motor commands
            frontLeftDrive.setPower(fwdcmd + stfcmd + trncmd);
            frontRightDrive.setPower(fwdcmd - stfcmd - trncmd);
            backLeftDrive.setPower(fwdcmd - stfcmd + trncmd);
            backRightDrive.setPower(fwdcmd + stfcmd - trncmd);

            telemetry.addData("Scoop Motor Command", ScoopMotor.getPower());
            telemetry.update();
        }
    }
}
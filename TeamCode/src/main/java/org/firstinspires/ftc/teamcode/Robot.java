package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

enum RightTriggerResponseType {
    RIGHT_SIDE_POWERED_POSITIVE, RIGHT_SIDE_POWERED_NEGATIVE, STRAFE_FORWARD_RIGHT_POSITIVE, STRAFE_BACKWARD_RIGHT_NEGATIVE
}
enum LeftTriggerResponseType {
    LEFT_SIDE_POWERED_POSITIVE, LEFT_SIDE_POWERED_NEGATIVE, STRAFE_FORWARD_LEFT_POSITIVE, STRAFE_BACKWARD_LEFT_NEGATIVE
}

public class Robot{
    ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backLeftDrive;
    private DcMotor backRightDrive;

    // Constructor
    Robot(HardwareMap map) {
        frontLeftDrive = map.dcMotor.get("front_left_drive");
        backLeftDrive = map.dcMotor.get("back_left_drive");
        frontRightDrive = map.dcMotor.get("front_right_drive");
        backRightDrive = map.dcMotor.get("back_right_drive");

        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    void respondToRightTrigger(RightTriggerResponseType rt, double powerLevel) {
        powerLevel = Math.abs(powerLevel)/2;
        switch(rt) {
            case RIGHT_SIDE_POWERED_NEGATIVE:
                frontRightDrive.setPower(-powerLevel);
                backRightDrive.setPower(-powerLevel);
            case RIGHT_SIDE_POWERED_POSITIVE:
                frontRightDrive.setPower(powerLevel);
                backRightDrive.setPower(powerLevel);
            case STRAFE_FORWARD_RIGHT_POSITIVE:
                frontLeftDrive.setPower(powerLevel);
                backRightDrive.setPower(powerLevel);
            case STRAFE_BACKWARD_RIGHT_NEGATIVE:
                frontLeftDrive.setPower(-powerLevel);
                backRightDrive.setPower(-powerLevel);
        }
    }

    void respondToLeftTrigger(LeftTriggerResponseType lt, double powerLevel) {
        powerLevel = Math.abs(powerLevel)/2;
        switch(lt) {
            case LEFT_SIDE_POWERED_NEGATIVE:
                frontLeftDrive.setPower(-powerLevel);
                backLeftDrive.setPower(-powerLevel);
            case LEFT_SIDE_POWERED_POSITIVE:
                frontLeftDrive.setPower(powerLevel);
                backLeftDrive.setPower(powerLevel);
            case STRAFE_FORWARD_LEFT_POSITIVE:
                frontRightDrive.setPower(powerLevel);
                backLeftDrive.setPower(powerLevel);
            case STRAFE_BACKWARD_LEFT_NEGATIVE:
                frontRightDrive.setPower(-powerLevel);
                backLeftDrive.setPower(-powerLevel);
        }
    }

    void emptyMotors() {frontLeftDrive.setPower(0);backRightDrive.setPower(0);backLeftDrive.setPower(0);frontRightDrive.setPower(0);}

    void frontLeftMotor(double powerLevel) {
        frontLeftDrive.setPower(powerLevel/2);
    }

    void backLeftMotor(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
    }

    void frontRightMotor(double powerLevel) {
        frontRightDrive.setPower(powerLevel/2);
    }

    void backRightMotor(double powerLevel) {
        backRightDrive.setPower(powerLevel/2);
    }

    void allMotors(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
        backRightDrive.setPower(powerLevel/2);
        frontLeftDrive.setPower(powerLevel/2);
        frontRightDrive.setPower(powerLevel/2);
    }
}

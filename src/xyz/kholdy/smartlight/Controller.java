package xyz.kholdy.smartlight;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {

    private static final int PORT = 8888;
    private static final char ON = '1';
    private static final char OFF = '0';

    @FXML
    private ToggleButton btnHallway;

    @FXML
    private ToggleButton btnKitchen;

    @FXML
    private ToggleButton btnBedroom;

    @FXML
    private ToggleButton btnLivingRoom;

    @FXML
    void handlerBtnBedroom(ActionEvent event) {
        switchLight(Ip.BEDROOM.getValue(), btnBedroom);
    }

    @FXML
    void handlerBtnHallway(ActionEvent event) {
        switchLight(Ip.HALLWAY.getValue(), btnHallway);
    }

    @FXML
    void handlerBtnKitchen(ActionEvent event) throws IOException {
        switchLight(Ip.KITCHEN.getValue(), btnKitchen);
    }

    @FXML
    void handlerBtnLivingRom(ActionEvent event) {
        switchLight(Ip.LIVINGROOM.getValue(), btnLivingRoom);
    }

    private void switchLight(String ip, ToggleButton btn) {
        try(Socket socket = new Socket(ip, PORT);
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream())) {

            if (btn.isSelected()) {
                dataOutput.writeChar(ON);
            } else {
                dataOutput.writeChar(OFF);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

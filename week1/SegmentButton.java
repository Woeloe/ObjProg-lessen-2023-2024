package be.ugent.objprog.week1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SegmentButton extends Button implements EventHandler<ActionEvent> {

    private int count;
    private final SegmentPanel panel;

    public SegmentButton (SegmentPanel panel) {
        super ("+ 1");
        this.panel = panel;
        this.count = 0;
        setOnAction(this);
        show (0);
    }

    @Override
    public void handle(ActionEvent event) {
        count = (count + 1) % 10;
        show (count);
    }

    private static final boolean[][] SEGMENTS = {
        { false, true, true, true, true, true, true },     // 0
        { false, false, true, false, false, false, true }, // 1
        { true, false, true, true, true, true, false },    // 2
        { true, false, true, true, true, false, true },    // 3
        { true, true, true, false, false, false, true },   // 4
        { true, true, false, true, true, false, true },    // 5
        { true, true, false, true, true, true, true },     // 6
        { false, false, true, true, false, false, true },  // 7
        { true, true, true, true, true, true, true },      // 8
        { true, true, true, true, true, false, true },     // 9

    };

    private void show (int digit) {
        for (int i = 0; i < 7; i++) {
            if (SEGMENTS[digit][i]) {
                panel.setOn (i);
            } else {
                panel.setOff (i);
            }
        }
    }

    /* Opmerking

       Er zijn nog andere manieren om dit op te lossen.
       Je zou 0/1 kunnen gebruiken in plaats van true/false
       omdat dit de leesbaarheid ten goede komt (maar nog steeds in een 2-dimensionale tabel), of zelfs
       een 1-dimensionale tabel van strings: { "0111111", "0010001", … } of waarom niet {".++++++", "..+...+", …}.

       Gebruik GEEN map. Als de 'sleutel' een opeenvolgend bereik van gehele getallen is, is het altijd beter (en sneller)
       om een array te gebruiken.
     */
}

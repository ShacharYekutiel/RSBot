package RS3.RS3Fisher;

import org.powerbot.script.Client;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name = "RS3Fisher", description = "Fish anything anywhere")
public class RS3Fisher extends PollingScript<ClientContext> implements PaintListener {

    @Override
    public void start() {}
    @Override
    public void repaint(Graphics graphics) {

    }

    @Override
    public void poll() {
    }
}

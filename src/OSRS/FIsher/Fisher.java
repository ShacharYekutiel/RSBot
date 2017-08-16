package OSRS.FIsher;

import OSRS.FIsher.Actions.Bank;
import OSRS.FIsher.Actions.Drop;
import OSRS.FIsher.Actions.Fish;
import OSRS.FIsher.Actions.Walk;
import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name = "Fisher", description = "AIO Fisher", properties = "Client 4")
public class Fisher extends PollingScript<ClientContext> {
    List<Task> taskList = new ArrayList<Task>();

    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
                break;
            }
            if (Variables.fishingArea.contains(ctx.players.local()))
                System.out.println("Im at the fishing area");
            if (Variables.bankArea.contains(ctx.players.local()))
                System.out.println("Im at bank area");

        }
    }
    @Override
    public void start() {
        Variables.rodID = Variables.Small_Net_ID;
        Variables.method = "Net";
        Variables.fishID = Variables.Shrimp_ID;
        Variables.spot = Variables.Shrimp_Spot;
        Variables.fishingArea = Variables.Lumbridge_Swamp;
        Variables.bankArea = Variables.Lumbridge_Castle;
        /*
        if (Variables.powerFish) { taskList.add(new Drop(ctx)); }
         */
        taskList.add(new Bank(ctx));
        taskList.add(new Walk(ctx));
        taskList.add(new Fish(ctx));
        Variables.pathToBank = Variables.Lumbridge_Swamp_To_Castle;
    }

    public static void messaged(MessageEvent messageEvent) {
        String txt = messageEvent.text().toLowerCase();
        if (txt.contains("I can't reach that!")) {
            Fish.cantReach = true;
        }
    }
}

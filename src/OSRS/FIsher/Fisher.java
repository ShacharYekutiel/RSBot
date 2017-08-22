package OSRS.FIsher;

import OSRS.FIsher.Actions.Bank;
import OSRS.FIsher.Actions.Drop;
import OSRS.FIsher.Actions.Fish;
import OSRS.FIsher.Actions.Walk;
import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Script.Manifest(name = "Fisher", description = "AIO Fisher", properties = "Client 4")
public class Fisher extends PollingScript<ClientContext> implements PaintListener, MessageListener {
    private List<Task> taskList = new ArrayList<Task>();
    private Variables ids = new Variables();
    static boolean guiWait = true;
    private GUI gui = new GUI();
    int startExp = 0;
    int caughts = 0;
    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
                break;
            }
        }
        if (Variables.fishingArea.contains(ctx.players.local().tile()))
            System.out.println("Im in fishing spot!!!");
    }
    @Override
    public void start() {
        gui.setVisible(true);
        while (guiWait) {
            Variables.status = "Waiting for GUI...";
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !guiWait;
                }
            });
        }
        startExp = ctx.skills.experience(Constants.SKILLS_FISHING);
        System.out.println(Variables.rodID);
        System.out.println(Variables.powerFishing);
        taskList.add(new Drop(ctx));
        taskList.add(new Bank(ctx));
        taskList.add(new Walk(ctx));
        taskList.add(new Fish(ctx));
    }
    @Override
    public void repaint(Graphics graphics) {
        int expGained = ctx.skills.experience(Constants.SKILLS_FISHING)-startExp;

        Graphics2D g = (Graphics2D)graphics; //get 2d graphics
        g.setColor(new Color(0,0,0,180)); //max is 255.
        g.fillRect(0,0,180,160); //draws rectangle


        g.setColor(new Color(255,255,255)); //draws white border
        g.drawRect(0,0,180,160); //same as first

        g.drawString("Shachar's AIO Fisher", 10, 20); //add text into rectangle
        g.drawString("Time : " + getRunningTime(), 10, 40 );
        g.drawString("Status:" + Variables.status, 10, 60);
        g.drawString("Exp Gained: " + expGained, 10, 80);
        g.drawString("Exp/Hour " + (int)(expGained * (3600000 / getTotalRuntime())), 10, 100); //divides milliseconds/hr by /milliseconds
        g.drawString("Fish Caught: " + caughts, 10,120);
        g.drawString("Fish Caught/Hour: " + (int) (caughts * (3600000 / getTotalRuntime())), 10, 140);

    }
    private String getRunningTime(){
        long milliseconds = this.getTotalRuntime();
        long seconds = (milliseconds / 1000) % 60;
        long minutes = (milliseconds / (1000 * 60) % 60);
        long hours = (milliseconds / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        if (messageEvent.text().contains("You catch some"))
            caughts++;
    }
}

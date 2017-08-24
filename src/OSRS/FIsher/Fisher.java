package OSRS.FIsher;

import OSRS.FIsher.Actions.Bank;
import OSRS.FIsher.Actions.Drop;
import OSRS.FIsher.Actions.Fish;
import OSRS.FIsher.Actions.Walk;
import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import javafx.scene.control.Tab;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Script.Manifest(name = "Fisher", description = "AIO Fisher", properties = "Client 4")
public class Fisher extends PollingScript<ClientContext> implements PaintListener, MessageListener, MouseListener {
    private List<Task> taskList = new ArrayList<Task>();
    static boolean guiWait = true;
    private GUI gui = new GUI();
    private int startExp = ctx.skills.experience(Constants.SKILLS_FISHING);
    private int caught;
    private int expGained;
    private int startLvl = ctx.skills.realLevel(Constants.SKILLS_FISHING);
    private int lvlGained;
    Image img1 = getImage("https://vignette4.wikia.nocookie.net/2007scape/images/0/0b/Fishing-icon.png/revision/latest?cb=20141020205029");
    private Rectangle tab1 = new Rectangle(15, 20, 20, 20);
    private Rectangle tab2 = new Rectangle(15, 45, 20, 20);
    private Rectangle tab3 = new Rectangle(15, 70,20,20);
    private boolean Tab1_isOpen;
    private boolean Tab2_isOpen;
    private boolean Tab3_isOpen;
    private Point p;

    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
                break;
            }
        }
        if (ctx.movement.energyLevel() > 40)
            ctx.movement.running(true);
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
        taskList.add(new Drop(ctx));
        taskList.add(new Bank(ctx));
        taskList.add(new Walk(ctx));
        taskList.add(new Fish(ctx));
    }

    private Image getImage(String image) {
        try {
            return ImageIO.read(new URL(image));
        }
        catch (IOException e) { return null; }
    }
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics; //get 2d graphics
        g.setColor(new Color(0,0,0,180)); //max is 255.
        g.fillRect(0,0,165,190); //draws rectangle


        g.setColor(new Color(255,255,255)); //draws white border
        g.drawRect(0,0,165,190); //same as first
        g.drawImage(img1, 10, 10, null);
        g.drawString("Shachar's AIO Fisher", 10, 20); //add text into rectangle
        g.drawString("Time : " + getRunningTime(), 10, 40 );
        g.drawString("Status:" + Variables.status, 10, 60);
        g.drawString("Exp Gained: " + getExpGained(), 10, 80);
        g.drawString("Exp/Hour " + (int)(expGained * (3600000 / getTotalRuntime())), 10, 100); //divides milliseconds/hr by /milliseconds
        g.drawString("Lvl's Gained: " + getLvlGained(), 10, 120);
        g.drawString("Lvl's/Hour: " + (int) (lvlGained * (3600000 / getTotalRuntime())), 10, 140);
        g.drawString("Fish Caught: " + caught, 10,160);
        g.drawString("Fish Caught/Hour: " + (int) (caught * (3600000 / getTotalRuntime())), 10, 180);

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
        if (messageEvent.text().contains("You catch"))
            caught++;
    }

    public int getExpGained() {
        expGained = ctx.skills.experience(Constants.SKILLS_FISHING) - startExp;
        return expGained;
    }
    public int getLvlGained() {
        lvlGained = ctx.skills.realLevel(Constants.SKILLS_FISHING) - startLvl;
        return lvlGained;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        p = e.getPoint();
        if (tab1.contains(p)) {
            if (Tab1_isOpen) {
                Tab1_isOpen = false;
                System.out.println("Closing tab 1");
            }
            else {
                Tab2_isOpen = false;
                Tab3_isOpen = false;
                Tab1_isOpen = true;
                System.out.println("Opening tab 1");
            }
        }
        if (tab2.contains(p)) {
            if (Tab2_isOpen) {
                Tab2_isOpen = false;
                System.out.println("Closing tab 2");
            }
            else {
                Tab2_isOpen = true;
                Tab3_isOpen = false;
                Tab1_isOpen = false;
                System.out.println("Opening tab 2");
            }
        }
        if (tab3.contains(p)) {
            if (Tab3_isOpen) {
                Tab3_isOpen = false;
                System.out.println("Closing tab 3");
            }
            else {
                Tab3_isOpen = true;
                Tab2_isOpen = false;
                Tab1_isOpen = false;
                System.out.println("Opening tab 3");
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

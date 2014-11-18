import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class altclock extends Applet
    implements Runnable
{

    public void GetRealTime()
    {
        currDate = new Date();
        HourNow = currDate.getHours();
        MinNow = currDate.getMinutes();
        if(HourNow >= 12)
            hour = HourNow - 12;
        else
            hour = HourNow;
        if(MinNow % 5 == 0)
        {
            minhour = MinNow / 5;
            minmin = 0;
        } else
        {
            minhour = MinNow / 5;
            minmin = MinNow - minhour * 5;
        }
    }

    public void updateMinhour(String newColor)
    {
        colorMinhour = stringToColor(newColor);
        repaint();
    }

    public void stop()
    {
        ClockThread.stop();
        ClockThread = null;
    }

    public void updatePause(String newP)
    {
        if(Integer.parseInt(newP) != 0)
        {
            ClockThread.stop();
        } else
        {
            ClockThread = new Thread(this);
            ClockThread.start();
        }
    }

    public void updateData()
    {
        iHMsrtA[0] = 90;
        iHMsrtA[1] = 60;
        iHMsrtA[2] = 30;
        iHMsrtA[3] = 0;
        iHMsrtA[4] = 330;
        iHMsrtA[5] = 300;
        iHMsrtA[6] = 270;
        iHMsrtA[7] = 240;
        iHMsrtA[8] = 210;
        iHMsrtA[9] = 180;
        iHMsrtA[10] = 150;
        iHMsrtA[11] = 120;
        iHMarcA[0][1] = -30;
        iHMarcA[0][2] = -60;
        iHMarcA[0][3] = -90;
        iHMarcA[0][4] = -120;
        iHMarcA[0][5] = -150;
        iHMarcA[0][6] = -180;
        iHMarcA[0][7] = -210;
        iHMarcA[0][8] = -240;
        iHMarcA[0][9] = -270;
        iHMarcA[0][10] = -300;
        iHMarcA[0][11] = -330;
        iHMarcA[1][0] = -330;
        iHMarcA[1][2] = -30;
        iHMarcA[1][3] = -60;
        iHMarcA[1][4] = -90;
        iHMarcA[1][5] = -120;
        iHMarcA[1][6] = -150;
        iHMarcA[1][7] = -180;
        iHMarcA[1][8] = -210;
        iHMarcA[1][9] = -240;
        iHMarcA[1][10] = -270;
        iHMarcA[1][11] = -300;
        iHMarcA[2][0] = -300;
        iHMarcA[2][1] = -330;
        iHMarcA[2][3] = -30;
        iHMarcA[2][4] = -60;
        iHMarcA[2][5] = -90;
        iHMarcA[2][6] = -120;
        iHMarcA[2][7] = -150;
        iHMarcA[2][8] = -180;
        iHMarcA[2][9] = -210;
        iHMarcA[2][10] = -240;
        iHMarcA[2][11] = -270;
        iHMarcA[3][0] = -270;
        iHMarcA[3][1] = -300;
        iHMarcA[3][2] = -330;
        iHMarcA[3][4] = -30;
        iHMarcA[3][5] = -60;
        iHMarcA[3][6] = -90;
        iHMarcA[3][7] = -120;
        iHMarcA[3][8] = -150;
        iHMarcA[3][9] = -180;
        iHMarcA[3][10] = -210;
        iHMarcA[3][11] = -240;
        iHMarcA[4][0] = -240;
        iHMarcA[4][1] = -270;
        iHMarcA[4][2] = -300;
        iHMarcA[4][3] = -330;
        iHMarcA[4][5] = -30;
        iHMarcA[4][6] = -60;
        iHMarcA[4][7] = -90;
        iHMarcA[4][8] = -120;
        iHMarcA[4][9] = -150;
        iHMarcA[4][10] = -180;
        iHMarcA[4][11] = -210;
        iHMarcA[5][0] = -210;
        iHMarcA[5][1] = -240;
        iHMarcA[5][2] = -270;
        iHMarcA[5][3] = -300;
        iHMarcA[5][4] = -330;
        iHMarcA[5][6] = -30;
        iHMarcA[5][7] = -60;
        iHMarcA[5][8] = -90;
        iHMarcA[5][9] = -120;
        iHMarcA[5][10] = -150;
        iHMarcA[5][11] = -180;
        iHMarcA[6][0] = -180;
        iHMarcA[6][1] = -210;
        iHMarcA[6][2] = -240;
        iHMarcA[6][3] = -270;
        iHMarcA[6][4] = -300;
        iHMarcA[6][5] = -330;
        iHMarcA[6][7] = -30;
        iHMarcA[6][8] = -60;
        iHMarcA[6][9] = -90;
        iHMarcA[6][10] = -120;
        iHMarcA[6][11] = -150;
        iHMarcA[7][0] = -150;
        iHMarcA[7][1] = -180;
        iHMarcA[7][2] = -210;
        iHMarcA[7][3] = -240;
        iHMarcA[7][4] = -270;
        iHMarcA[7][5] = -300;
        iHMarcA[7][6] = -330;
        iHMarcA[7][8] = -30;
        iHMarcA[7][9] = -60;
        iHMarcA[7][10] = -90;
        iHMarcA[7][11] = -120;
        iHMarcA[8][0] = -120;
        iHMarcA[8][1] = -150;
        iHMarcA[8][2] = -180;
        iHMarcA[8][3] = -210;
        iHMarcA[8][4] = -240;
        iHMarcA[8][5] = -270;
        iHMarcA[8][6] = -300;
        iHMarcA[8][7] = -330;
        iHMarcA[8][9] = -30;
        iHMarcA[8][10] = -60;
        iHMarcA[8][11] = -90;
        iHMarcA[9][0] = -90;
        iHMarcA[9][1] = -120;
        iHMarcA[9][2] = -150;
        iHMarcA[9][3] = -180;
        iHMarcA[9][4] = -210;
        iHMarcA[9][5] = -240;
        iHMarcA[9][6] = -270;
        iHMarcA[9][7] = -300;
        iHMarcA[9][8] = -330;
        iHMarcA[9][10] = -30;
        iHMarcA[9][11] = -60;
        iHMarcA[10][0] = -60;
        iHMarcA[10][1] = -90;
        iHMarcA[10][2] = -120;
        iHMarcA[10][3] = -150;
        iHMarcA[10][4] = -180;
        iHMarcA[10][5] = -210;
        iHMarcA[10][6] = -240;
        iHMarcA[10][7] = -270;
        iHMarcA[10][8] = -300;
        iHMarcA[10][9] = -330;
        iHMarcA[10][11] = -30;
        iHMarcA[11][0] = -30;
        iHMarcA[11][1] = -60;
        iHMarcA[11][2] = -90;
        iHMarcA[11][3] = -120;
        iHMarcA[11][4] = -150;
        iHMarcA[11][5] = -180;
        iHMarcA[11][6] = -210;
        iHMarcA[11][7] = -240;
        iHMarcA[11][8] = -270;
        iHMarcA[11][9] = -300;
        iHMarcA[11][10] = -330;
    }

    public void updateZero(String newIntVal)
    {
        zero = Integer.valueOf(newIntVal).intValue();
        repaint();
    }

    public void paint(Graphics gf)
    {
        int rB = (int)((double)RadiusB * k);
        int rS = (int)((double)RadiusS * k);
        gf.setColor(colorBG);
        gf.fillRect(0, 0, 300, 300);
        gf.setColor(colorMinhour);
        if(hour != minhour)
            gf.fillArc(cx - rB, cy - rB, 2 * rB, 2 * rB, iHMsrtA[hour], iHMarcA[hour][minhour]);
        else
            gf.fillArc(cx - rB, cy - rB, 2 * rB, 2 * rB, iHMsrtA[hour] + zero, -2 * zero);
        gf.setColor(colorBG);
        gf.fillOval(cx - rS, cy - rS, 2 * rS, 2 * rS);
        gf.setColor(colorMinmin);
        switch(minmin)
        {
        case 1: // '\001'
            gf.fillArc(cx - rS, cy - rS, 2 * rS, 2 * rS, 90, -90);
            break;

        case 2: // '\002'
            gf.fillArc(cx - rS, cy - rS, 2 * rS, 2 * rS, 90, -180);
            break;

        case 3: // '\003'
            gf.fillArc(cx - rS, cy - rS, 2 * rS, 2 * rS, 90, -270);
            break;

        case 4: // '\004'
            gf.fillArc(cx - rS, cy - rS, 2 * rS, 2 * rS, 90, -360);
            break;
        }
        gf.setColor(colorBorder);
        gf.drawOval(cx - rB, cy - rB, 2 * rB, 2 * rB);
        gf.drawOval(cx - rS, cy - rS, 2 * rS, 2 * rS);
        if(BorderIn)
        {
            for(int i = 0; i < 12; i++)
            {
                double angle = ((double)(30 * i) * 3.1415926535897931D) / 180D;
                int aB = (int)Math.rint((double)((rB * 2) / 2) * Math.sin(angle));
                int bB = (int)Math.rint((double)((rB * 2) / 2) * Math.cos(angle));
                int aS = (int)Math.rint((double)((rS * 2) / 2) * Math.sin(angle));
                int bS = (int)Math.rint((double)((rS * 2) / 2) * Math.cos(angle));
                gf.drawLine((cx - rS) + (rS * 2) / 2 + bS, ((cy - rS) + (rS * 2) / 2) - aS, (cx - rB) + (rB * 2) / 2 + bB, ((cy - rB) + (rB * 2) / 2) - aB);
            }

            gf.drawLine(cx - rS, cy, cx + rS, cy);
            gf.drawLine(cx, cy - rS, cx, cy + rS);
        }
    }

    public void AltClock()
    {
        defBG = Color.white;
        defBorder = Color.black;
        defMinhour = new Color(28051);
        defMinmin = new Color(0xe8aa00);
        colorBG = defBG;
        colorBorder = defBorder;
        colorMinhour = defMinhour;
        colorMinmin = defMinmin;
        cx = 150;
        cy = 150;
        RadiusB = 50;
        RadiusS = (int)((double)RadiusB * 0.5D);
        iHMsrtA = new int[12];
        iHMarcA = new int[12][12];
        k = 2.6000000000000001D;
        zero = 5;
        myDelay = 500;
        RealTime = false;
        BorderIn = true;
    }

    public void updateBG(String newColor)
    {
        colorBG = stringToColor(newColor);
        repaint();
    }

    public void destroy()
    {
        ClockThread.stop();
        ClockThread = null;
    }

    public void initForm()
    {
        setBackground(colorBG);
        setForeground(colorBorder);
    }

    public void updateDelay(String newIntVal)
    {
        myDelay = Integer.valueOf(newIntVal).intValue();
        repaint();
    }

    public void updateMinmin(String newColor)
    {
        colorMinmin = stringToColor(newColor);
        repaint();
    }

    public void update(Graphics g)
    {
        Graphics offScreenGraphics = offScreenImage.getGraphics();
        offScreenGraphics.setColor(getBackground());
        offScreenGraphics.fillRect(0, 0, size().width, size().height);
        offScreenGraphics.setColor(g.getColor());
        paint(offScreenGraphics);
        g.drawImage(offScreenImage, 0, 0, this);
    }

    public void updateK(String newIntVal)
    {
        switch(Integer.valueOf(newIntVal).intValue())
        {
        case 1: // '\001'
            k = 0.10000000000000001D;
            break;

        case 2: // '\002'
            k = 0.14999999999999999D;
            break;

        case 3: // '\003'
            k = 0.20000000000000001D;
            break;

        case 4: // '\004'
            k = 0.29999999999999999D;
            break;

        case 5: // '\005'
            k = 0.40000000000000002D;
            break;

        case 6: // '\006'
            k = 0.5D;
            break;

        case 7: // '\007'
            k = 0.59999999999999998D;
            break;

        case 8: // '\b'
            k = 0.69999999999999996D;
            break;

        case 9: // '\t'
            k = 0.80000000000000004D;
            break;

        case 10: // '\n'
            k = 0.90000000000000002D;
            break;

        case 11: // '\013'
            k = 1.0D;
            break;

        case 12: // '\f'
            k = 1.1000000000000001D;
            break;

        case 13: // '\r'
            k = 1.2D;
            break;

        case 14: // '\016'
            k = 1.3D;
            break;

        case 15: // '\017'
            k = 1.3999999999999999D;
            break;

        case 16: // '\020'
            k = 1.5D;
            break;

        case 17: // '\021'
            k = 1.6000000000000001D;
            break;

        case 18: // '\022'
            k = 1.7D;
            break;

        case 19: // '\023'
            k = 1.8D;
            break;

        case 20: // '\024'
            k = 1.8999999999999999D;
            break;

        case 21: // '\025'
            k = 2D;
            break;

        case 22: // '\026'
            k = 2.1000000000000001D;
            break;

        case 23: // '\027'
            k = 2.2000000000000002D;
            break;

        case 24: // '\030'
            k = 2.2999999999999998D;
            break;

        case 25: // '\031'
            k = 2.3999999999999999D;
            break;

        case 26: // '\032'
            k = 2.5D;
            break;

        case 27: // '\033'
            k = 2.6000000000000001D;
            break;

        case 28: // '\034'
            k = 2.7000000000000002D;
            break;

        case 29: // '\035'
            k = 2.7999999999999998D;
            break;

        case 30: // '\036'
            k = 2.8999999999999999D;
            break;

        case 31: // '\037'
            k = 2.98D;
            break;
        }
        repaint();
    }

    public void start()
    {
        GetRealTime();
        updateData();
        if(ClockThread == null)
        {
            ClockThread = new Thread(this);
            ClockThread.start();
        }
    }

    public void updateBorderIn(String newIn)
    {
        if(Integer.parseInt(newIn) != 0)
            BorderIn = false;
        else
            BorderIn = true;
        repaint();
    }

    public void updateBorder(String newColor)
    {
        colorBorder = stringToColor(newColor);
        repaint();
    }

    public void run()
    {
        Thread.currentThread().setPriority(5);
        do
        {
            while(!RealTime) 
            {
                repaint();
                if(minmin != 4)
                {
                    minmin++;
                } else
                {
                    minmin = 0;
                    if(minhour < 12)
                    {
                        minhour++;
                    } else
                    {
                        minhour = 0;
                        if(hour < 12)
                            hour++;
                        else
                            hour = 0;
                    }
                }
                try
                {
                    Thread.sleep(myDelay);
                }
                catch(Exception sleepProblem) { }
            }
            if(minhour != MinNow)
            {
                GetRealTime();
                repaint();
            } else
            {
                currDate = new Date();
                minhour = currDate.getMinutes();
                MinNow = currDate.getMinutes();
            }
        } while(true);
    }

    public void init()
    {
        try
        {
            if(getParameter("BG") != null)
                updateBG(getParameter("BG"));
            if(getParameter("Border") != null)
                updateBorder(getParameter("Border"));
            if(getParameter("Minhour") != null)
                updateMinhour(getParameter("Minhour"));
            if(getParameter("Minmin") != null)
                updateMinmin(getParameter("Minmin"));
            if(getParameter("K") != null)
                updateK(getParameter("K"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            GetRealTime();
            updateData();
            offScreenImage = createImage(size().width, size().height);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private Color stringToColor(String paramValue)
    {
        int red = Integer.decode("0x" + paramValue.substring(0, 2)).intValue();
        int green = Integer.decode("0x" + paramValue.substring(2, 4)).intValue();
        int blue = Integer.decode("0x" + paramValue.substring(4, 6)).intValue();
        return new Color(red, green, blue);
    }

    public void updateRealTime(String newSync)
    {
        if(Integer.parseInt(newSync) != 0)
            RealTime = true;
        else
            RealTime = false;
        GetRealTime();
        repaint();
    }

    Color defBG;
    Color defBorder;
    Color defMinhour;
    Color defMinmin;
    Color colorBG;
    Color colorBorder;
    Color colorMinhour;
    Color colorMinmin;
    int cx;
    int cy;
    public int HourNow;
    public int MinNow;
    public int hour;
    public int minhour;
    public int minmin;
    public int RadiusB;
    public int RadiusS;
    private int iHMsrtA[];
    private int iHMarcA[][];
    Date currDate;
    Thread ClockThread;
    public double k;
    public int zero;
    public int myDelay;
    boolean RealTime;
    boolean BorderIn;
    private Image offScreenImage;
}
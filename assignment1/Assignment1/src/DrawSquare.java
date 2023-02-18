import java.awt.*;
import java.awt.event.*;
public class DrawSquare extends Frame implements MouseListener
{

    int x1, y1, x2, y2;
    int points = 0;
    public DrawSquare()
    {
        addMouseListener(this);
        Dimension d = getMaximumSize();
        setSize(d.width,d.height);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void mouseClicked(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        points++;
        paintComponents(getGraphics());

    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    // overriding paintComponents() function for drawing the square and naming it
    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);
//if user clicks 2 times then drawing the square using drawRect() function and naming it
        if(points == 2)
        {
            int side = Math.abs(y2-y1);
            x2 = x1;
            y2 = y1+side;
            g.fillOval(x2-3, y2-3, 8, 8);
            g.fillOval(x2+side-4, y2-3, 8, 8);
            g.fillOval(x1+side-4, y1-1, 8, 8);
            g.drawRect(x1, y1,side, side);
            g.setFont(new Font("Monospaced", Font.BOLD, 20));
            g.drawString("A", x1-9, y1-5);
            g.drawString("D", x2+side+3, y1-7);
            g.drawString("B", x1-10,y2+16);
            g.drawString("C", x2+side+2,y2+14);
        }
// if user clicks the mouse one time painting a point to mark the click location
        if(points == 1)
        {
            g.fillOval(x2-1, y2-1, 8, 8);
            x1 = x2;
            y1 = y2;
        }
// exiting the program when user clicks mouse more than 2 times
        if (points>2)
        {
            dispose();
        }
    }
    public static void main(String args[])
    {
        new DrawSquare();


    }

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;

public class PrintText implements Printable {

    int[] pages;
    String text;
    String[] textLines;

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
             
		Font font = new Font("Times New Roman", Font.PLAIN, 10);
		FontMetrics fontMetrics = graphics.getFontMetrics(font);
		int lineHeight = fontMetrics.getHeight();
		if(pages == null) {
			initTextLines();
			int linesPerPage = (int)(pageFormat.getImageableHeight() / lineHeight);
			int numPageBreaks = (textLines.length - 1) / linesPerPage;
			pages = new int[numPageBreaks];
				for(int a = 0; a < pages.length; a++) {
					pages[a] = (a + 1) * linesPerPage; 
			}
		}

			if(pageIndex > pages.length) {
				return NO_SUCH_PAGE;	
	}

	Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		int y = 0;
		int start = (pageIndex == 0) ? 0: pages[pageIndex - 1];
		int end = (pageIndex == pages.length) ? textLines.length: pages[pageIndex];
			for(int line = start; line < end; line++) {
			y += lineHeight;
			g2d.drawString(textLines[line], 0, y);
			}
		return PAGE_EXISTS;	
    }

    private void initTextLines() {
    	if(textLines == null) {
		splitter();    		
		}
    }

    private void splitter() {
    	String[] arrayText = text.split("\n");
		textLines = arrayText;
    }

    public void printerJob(String value) {
    	text = value;
		PrinterJob job = PrinterJob.getPrinterJob();
    	PageFormat pageFormat = new PageFormat();
    	pageFormat.setOrientation(PageFormat.PORTRAIT);
		Paper paper = new Paper();
    	pageFormat.setPaper(paper);
		job.setPrintable(this, pageFormat);
		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (PrinterException e) {
				System.out.println(e);
			}
		}
    }
}
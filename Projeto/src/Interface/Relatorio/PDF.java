/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Relatorio;

/**
 *
 * @author jeanbrock
 */
import com.itextpdf.text.BadElementException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class PDF {

    private static PrintService impressora;
    Document doc = null;
    OutputStream os = null;

    public void criaPDF() throws FileNotFoundException, DocumentException {
        if (doc == null) {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            //cria a stream de saída
            os = new FileOutputStream("Relatório.pdf");

            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
        } else {
            System.out.println("Documento já existente!");
        }

    }

    public void abrePDF() {
        if (doc != null) {
            //abre o documento
            doc.open();
        }

    }

    public void fechaPDF() throws IOException {
        if (doc != null) {
            //fechamento do documento
            doc.close();
        }
        if (os != null) {
            //fechamento da stream de saída
            os.close();
        }
    }

    public void addTituloPDF(String titulo) throws DocumentException {
//        abrePDF();
        Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        Paragraph p1 = new Paragraph(titulo, f);
        p1.setAlignment(Element.ALIGN_CENTER);
        p1.setSpacingAfter(20);
        doc.add(p1);
    }

    public void addLinhaPDF(String linha) throws DocumentException {
//        abrePDF();
        Paragraph p1 = new Paragraph(linha);
        doc.add(p1);
    }

    public void addImagemPDF(String pathImagem) throws BadElementException, IOException, DocumentException {
//        abrePDF();
        Image img = Image.getInstance(pathImagem);
        img.setAlignment(Element.ALIGN_CENTER);
//        img.scaleToFit(826, 1100);
        doc.add(img);
    }

    public void addTabela(String[] tabela) throws DocumentException {
//        abrePDF();
        //Edição largura das colunas
        //PdfPTable table = new PdfPTable(new float[] { 0.2f, 0.2f, 0.6f });

        //Mudando o tamanho e alinhamento da tabela
        //table.setWidthPercentage(60.0f);
        //table.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        Customizando as bordas e cores
//        header.setBackgroundColor(BaseColor.YELLOW);
//        header.setBorderWidthBottom(2.0f);
//        header.setBorderColorBottom(BaseColor.BLUE);
//        header.setBorder(Rectangle.BOTTOM);
        
        PdfPTable table = new PdfPTable(new float[]{0.2f,0.6f, 0.2f, 0.6f, 0.6f});
//        
        for (int i = 0; i < tabela.length; i++) {
            table.addCell(tabela[i]);
        }
        doc.add(table);
    }

    public void addHeaderTabela(String titulo, int colunas) {
        PdfPCell header = new PdfPCell(new Paragraph(titulo));
        header.setColspan(colunas);
    }

    public void carregaPDF(String path) throws IOException {
        String user = System.getProperty("user.name");
        path = "C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\Relatório.pdf";
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.open(new File(path));
    }

    public void imprimePDF(File path) {
        String user = System.getProperty("user.name");
        path = new File("C:\\Users\\" + user + "\\Documents\\NetBeansProjects\\projeto2\\Projeto\\Relatório.pdf");
        try {
            DocFlavor dflavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            impressora = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob dpj = impressora.createPrintJob();
            FileInputStream fis = new FileInputStream(path);
            byte[] buffer = new byte[fis.available()];
            int buff = 0;
            while ((buff = fis.available()) != 0) {
                fis.read(buffer, 0, buff);
            }
            System.out.println(new String(buffer));
            InputStream stream = new ByteArrayInputStream(buffer);
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(stream, flavor, null);
            dpj.print(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

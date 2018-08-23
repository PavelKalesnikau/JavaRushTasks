package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {
        createNewDocument();
    }

    public void resetDocument() {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());

        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());

        view.update();
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void setPlainText(String text) {
        try {
            resetDocument();
            StringReader stringReader = new StringReader(text);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader, document, 0);
                view.resetUndo();
                fileReader.close();
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile == null) {
            saveDocumentAs();
        } else {
            save(currentFile);
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            save(currentFile);
        }

    }

    public void save(File fileToSave) {
        try {
            FileWriter fileWriter = new FileWriter(fileToSave);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            fileWriter.close();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public void exit() {
        System.exit(0);
    }
}

package br.com.nobreak.biblioteca.beans;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;

@Named
public class BackupBean {


    public void gravarBackup() throws IOException {
        /*TODO: detectar o sistema operacional, realizar um backup para windows, um backup para linux e um backup para macOS*/
            String[] as = null;
//            File dir = new File("/home/moacir");
            File dir = new File("C:/Users/Daniel/Desktop");
//            Process p = Runtime.getRuntime().exec("sh /home/moacir/backup.sh", as, dir);
            Process p = Runtime.getRuntime().exec("cmd.exe /k bkpBiblioteca.bat", as, dir);
//            p.waitFor();
//            System.out.println(p.exitValue());
    }
}

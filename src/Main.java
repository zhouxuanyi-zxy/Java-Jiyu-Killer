/*
    Jiyu Killer Java Edition
    Version: v1.01
    License: MIT License
*/
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void fileExists(){
        Path NowDir = Paths.get("").toAbsolutePath();
        String NowPath = NowDir + "\\";
        File ck_pskill = new File(NowPath + "pskill.exe");
        File ck_ntsd = new File(NowPath + "ntsd.exe");
        if (ck_pskill.exists() && ck_ntsd.exists()){
            System.out.println("Files are OK");
        }
        if (!ck_pskill.exists()){
            System.out.println("Missed pskill");
            File file = new File(NowPath + "pskill.exe");
            downloadFile("https://gitee.com/zhouxuanyi/Python-Nanruan-Killer/raw/master/pskill.exe", file);

        }
        if (!ck_ntsd.exists()){
            System.out.println("Missed ntsd");
            File file = new File(NowPath + "ntsd.exe");
            downloadFile("https://gitee.com/zhouxuanyi/Python-Nanruan-Killer/raw/master/Python_Nanruan_Killer/ntsd.exe", file);
        }
        System.out.println("Files Now Are OK");
    }
    public static void downloadFile(String downloadUrl, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            URL url = new URL(downloadUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Download Error");
        }
    }
    public static void StartProcess(String ps_name) {
        List<String> ps = new ArrayList<>();
        Path NowDir = Paths.get("").toAbsolutePath();
        String ProgramPath;
        ProgramPath = NowDir + "\\";
        System.out.println(ProgramPath);
        if (ps_name == "pskill"){
            ProgramPath += ps_name + ".exe";
            ps.add(ProgramPath);
            ps.add("-t");
            ps.add("-nobanner");
            ps.add("StudentMain.exe");
        }else if (ps_name == "ntsd"){
            ProgramPath += ps_name + ".exe";
            ps.add(ProgramPath);
            ps.add("-c");
            ps.add("q");
            ps.add("-pn");
            ps.add("StudentMain.exe");
        }else if (ps_name == "taskkill") {
            ps.add("C:\\Windows\\System32\\" + ps_name);
            ps.add("/F");
            ps.add("/T");
            ps.add("/IM");
            ps.add("StudentMain.exe");
        }
        ProcessBuilder psBuilder = new ProcessBuilder();
        psBuilder.command(ps);
        psBuilder.redirectErrorStream(true);
        try {
            Process ps_start = psBuilder.start();
            ps_start.waitFor();
            InputStream input = ps_start.getInputStream();
            InputStream errors = ps_start.getErrorStream();
            int data = 0;
            String data1 = "";
            while ((data = input.read()) != -1){
                data1 += (char) data;
            }
//            System.out.println(data1);

            data = 0;
            data1 = "";
            while ((data = errors.read()) != -1){
                data1 += (char) data;
            }
//            System.out.println(data1);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void minimizeJiyu(String windowTitle){
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null,windowTitle);
        User32.INSTANCE.ShowWindow(hwnd,User32.SW_MINIMIZE);
    }
    public static boolean renameJiyu(String JiyuPath){
        File eXchange20_old = new File(JiyuPath+"eXchange20.dll");
        File eXchange20_new = new File(JiyuPath+"eXchange20.dll.1");
        return eXchange20_old.renameTo(eXchange20_new);
    }
    public static void main(String[] args) throws IOException {
        System.out.println("# Jiyu Killer Java Edition");
        System.out.println("# By Afefegeb");
        Path NowDir = Paths.get("").toAbsolutePath();
        String NowPath = NowDir + "\\";
        fileExists();
        StartProcess("taskkill");
        StartProcess("pskill");
    }
}

package com.lelyak.edu.utils;

import com.lelyak.edu.utils.logger.Logger;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.StandardCopyOption;

@UtilityClass
public class IOUtils {

    public final Charset UTF8 = StandardCharsets.UTF_8;

    public void copyFile(String fromPath, String toPath) {
        File from = new File(fromPath);
        File to = new File(toPath);

        try {
            Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException e) {
            Logger.error("Copy failed - fromPath=" + fromPath + ", toPath=" + toPath, new RuntimeException(e));
        }
    }

    public void saveFile(String filePath, String content) {
        try (BufferedWriter writer = getWriter(filePath, false)) {
            writer.write(content);
        } catch (Exception e) {
            Logger.error(StringUtils.appendStrings("saveFile throw Exception=%1$s"
                    + StringUtils.NEW_LINE + " with file path=%2$s with file content=%3$s", e.getMessage(), filePath, content));
        }
    }

    public BufferedReader getReader(String filePath) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), UTF8));
    }

    public BufferedWriter getWriter(String filePath, boolean append) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, append), UTF8));
    }

    public String readFileIntoString(String filePath) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = getReader(filePath)) {
            String line = reader.readLine();

            while (line != null) {
                result.append(line);
                result.append(System.lineSeparator());
                line = reader.readLine();
            }
        }
        return result.toString();
    }

    public String getAbsoluteFilePath(String partPath) {
        return new File(partPath).getAbsolutePath();
    }
}

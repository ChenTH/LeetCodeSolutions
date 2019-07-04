package com.cth.test;

public class fileProblemSloution {
    public static File maxFile(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        File files = new File(path);
        long max = Long.MIN_VALUE;
        File fname = null;
        for (File file : files.listFiles()) {
            if (file.isDirectory()) {
                boolean find = false;
                for (File f : file.listFiles()) {
                    if (f.isDirectory()) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    long size = foldSize(file);
                    if (size > max) {
                        fname = file;
                        max = size;
                    }
                }
            }
        }
        return fname;
    }

    public static long foldSize(File file) {
        if (!file.isDirectory()) {
            return file.size();
        } else {
            int sum = 0;
            for (File f : file.listFiles()) {
                sum += foldSize(f);
            }
            return sum;
        }
    }
}

package zielinskin.h2example.logic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DirectoryService {
    private static final Pattern MATCHER_FOR_COMMANDS = Pattern.compile("^(\\$ cd (\\w*))*(([\\d]*) (\\w*))*$");

    public Integer getTotalSize(String input) {
        FolderSize currentFolder = new FolderSize(new HashMap<>(), new HashMap<>(), null);

        List<String> commands = Arrays.asList(input.split("\n"));

        FolderSize topLevel = new FolderSize(new HashMap<>(), new HashMap<>(), null);

        commands.stream().filter(cmd ->


        ).forEach((cmd) -> {
            Matcher m = MATCHER_FOR_COMMANDS.matcher(cmd);
            if(m.matches()) {
                if(m.)
            }
            //cd
                //..

                //sub folder

            // file
        });

    }


    private static class FolderSize {
        private Map<String, FolderSize> subfolders;
        private Map<String, Integer> files;
        private FolderSize parent;

        public FolderSize(Map<String, FolderSize> subfolders, Map<String, Integer> files, FolderSize parent) {
            this.subfolders = subfolders;
            this.files = files;
            this.parent = parent;
        }

        public Map<String, FolderSize> getSubfolders() {
            return subfolders;
        }

        public Map<String, Integer> getFiles() {
            return files;
        }

        public FolderSize getParent() {
            return parent;
        }
    }
}

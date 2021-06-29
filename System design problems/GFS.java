package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Shorten: 
File to chunks: Use HashMap<String, List<String>> to represent chunk list
 
*/

/*Implement a simple client for GFS (Google File System, a distributed file system),
it provides the following methods:

read(filename). Read the file with given filename from GFS.
write(filename, content). Write a file with given filename & content to GFS.

There are two private methods that already implemented in the base class:

readChunk(filename, chunkIndex). Read a chunk from GFS.
writeChunk(filename, chunkIndex, chunkData). Write a chunk to GFS.

To simplify this question, we can assume that the chunk size is chunkSize bytes.
(In a real world system, it is 64M). The GFS Client's job is splitting a
file into multiple chunks (if need) and save to the remote GFS server.
chunkSize will be given in the constructor. You need to call these two
private methods to implement read & write methods.*/
public class GFS {
    // Definition of BaseGFSClient
    class BaseGFSClient {
        public BaseGFSClient() {
        }

        public String readChunk(String filename, int chunkIndex) {
            // Read a chunk from GFS
            return null;
        }

        public void writeChunk(String filename, int chunkIndex, String content) {
            // Write a chunk to GFS
        }
    }

    public class GFSClient extends BaseGFSClient {
        /*
         * @param chunkSize: An integer
         */
        Map<String, List<Integer>> fileChunk;
        int chunkIndex;

        public GFSClient(int chunkSize) {
            // do intialization if necessary
            fileChunk = new HashMap<String, List<Integer>>();
            chunkIndex = 0;
        }

        /*
         * @param filename: a file name
         * 
         * @return: conetent of the file given from GFS
         */
        public String read(String filename) {
            // write your code here
            StringBuilder sb = new StringBuilder();

            if (!fileChunk.containsKey(filename)) {
                return null;
            }

            List<Integer> chunks = fileChunk.get(filename);

            for (Integer i : chunks) {
                String chunkString = readChunk(filename, i);
                sb.append(chunkString);
            }

            return sb.toString();
        }

        /*
         * @param filename: a file name
         * 
         * @param content: a string
         * 
         * @return: nothing
         */
        public void write(String filename, String content) {
            // write your code here
            if (fileChunk.containsKey(filename)) {
                fileChunk.remove(filename);
            }
            List<Integer> chunks = new ArrayList<>();
            int i = 0;
            while (i < content.length()) {
                int count = 0;
                StringBuilder chunk = new StringBuilder();
                while (i <= content.length() && count < 5) {
                    chunk.append(content.charAt(i++));
                    count++;
                }
                writeChunk(filename, chunkIndex, chunk.toString());
                chunks.add(chunkIndex++);
            }
            fileChunk.put(filename, chunks);
        }
    }
}

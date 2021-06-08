package ro.ubb.model;

import lombok.*;

import java.io.*;

@Getter
@Setter
@Builder
public class Sensor {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String OK = "ok";
    public static final String ERROR = "error";

    private int id;
    private String name;
    private int data;
    private int upperBound;
    private int lowerBound;

    public void readFrom(InputStream is) throws IOException {
        var br = new BufferedReader(new InputStreamReader(is));
        id = Integer.parseInt(br.readLine());
        name = br.readLine();
        data = Integer.parseInt(br.readLine());
    }

    @Override
    public String toString() {
        return  this.id + LINE_SEPARATOR +
                this.name + LINE_SEPARATOR +
                this.data + LINE_SEPARATOR;
    }

    public void writeTo(OutputStream os) throws IOException {
        os.write((this.toString()).getBytes());
    }

}

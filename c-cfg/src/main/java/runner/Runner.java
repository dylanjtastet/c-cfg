package runner;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


import graph.Block;
import graph.Cfg;
import graph.EntryBlock;;
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Cfg cfg = new Cfg(new FileInputStream("C:\\Users\\djt0812\\research\\mm.c.011t.cfg.dot"));
			List<EntryBlock> entryblocks = cfg.getEntryPoints();
			Map<String, Block> blockmap = cfg.getBlockMap();
			Path sourceInput = FileSystems.getDefault().getPath("C:\\Users\\djt0812\\research\\mm.c");
			cfg.mapSource(sourceInput);
			System.out.println(cfg.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package runner;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import graph.Block;
import graph.Cfg;
import graph.EntryBlock;;
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Cfg cfg = new Cfg(new FileInputStream("C:\\Users\\lamem\\omp-test\\testomp.c.011t.cfg.dot"));
			List<EntryBlock> entryblocks = cfg.getEntryPoints();
			Map<String, Block> blockmap = cfg.getBlockMap();
			cfg.getBlockMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

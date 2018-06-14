package edu.cnm.deepdive.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException {
		  Path path = Paths.get("largest-product-data.txt");
		  Pattern pattern = Pattern.compile("\\s+");
		  int[][] data = readIntMatrix(path,pattern);
		}

		private static int[][] readIntMatrix(Path source, Pattern delimiter) throws IOException {
		  return Files.lines(source)
		        .map(new Function<String, int[]>() {

		          @Override
		          public int[] apply(String line) {
		            return delimiter.splitAsStream(line)
		                .mapToInt(new ToIntFunction<String>() {

		                  @Override
		                  public int applyAsInt(String value) {
		                    return Integer.parseInt(value);
		                  }

		                })
		                .toArray();
		          }

		        })
		        .collect(Collectors.toList())
		        .toArray(new int[0][]);
		}
}

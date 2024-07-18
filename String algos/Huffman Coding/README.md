# Huffman Coding in Java

## Overview

This Java program implements Huffman Coding, an algorithm used for lossless data compression. The main class `HuffmanCoding` contains a nested static class `HuffMan` which is responsible for encoding and decoding strings based on their character frequencies.

## How it Works

### Main Class: `HuffmanCoding`

The `HuffmanCoding` class includes a `main` method that creates an instance of the `HuffMan` class with a sample string and prints the encoded and decoded strings.

### Nested Class: `HuffMan`

The `HuffMan` class is responsible for the actual Huffman Coding process. It includes the following main components:

- **Fields**:
  - `encoder`: A `HashMap` that maps characters to their encoded binary strings.
  - `decoder`: A `HashMap` that maps encoded binary strings back to their characters.
  - `encoded`: A string that holds the encoded version of the input.
  - `decoded`: A string that holds the decoded version of the encoded string.

- **Constructor**:
  - The constructor initializes the encoder and decoder maps and calls the `initHuffMan` method with the input string.

- **Methods**:
  - `initHuffMan(String key)`: This method calculates the frequency of each character in the input string, builds a Huffman tree using a priority queue, and initializes the encoder and decoder maps by traversing the tree.
  - `initEncoderDecoder(Node root, String key)`: This method recursively traverses the Huffman tree to build the encoder and decoder maps.
  - `encode(String key)`: This method encodes the input string using the encoder map.
  - `decode(String key)`: This method decodes the encoded string using the decoder map.
  - `getEncodedString()`: Returns the encoded string.
  - `getDecodedString()`: Returns the decoded string.

### Node Class

The `Node` class represents a node in the Huffman tree. Each node contains:
- `left` and `right`: References to the left and right child nodes.
- `data`: The character data (for leaf nodes).
- `cost`: The frequency of the character.
- `compareTo(Node key)`: A method to compare nodes based on their cost.

## Example Usage

The `main` method demonstrates the usage of the `HuffMan` class with the string "abrakadabra". It prints the encoded and decoded strings.

```java
public class HuffmanCoding {
	public static void main(String[] args) {
        HuffMan huff = new HuffMan("abrakadabra");
        System.out.println(huff.getEncodedString());
        System.out.println(huff.getDecodedString());
	}

	static class HuffMan {
		private HashMap<Character, String> encoder;
		private HashMap<String, Character> decoder;
        private String encoded, decoded;

		HuffMan(String key) {
			this.encoder = new HashMap<>();
			this.decoder = new HashMap<>();
			initHuffMan(key);
		}

		private void initHuffMan(String key) {
			HashMap<Character, Integer> freq = new HashMap<>();
			for (char c : key.toCharArray()) {
				freq.put(c, freq.getOrDefault(c, 0) + 1);
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (HashMap.Entry<Character, Integer> entry : freq.entrySet()) {
				Node newNode = new Node(entry.getKey(), entry.getValue());
				pq.offer(newNode);
			}

			while (pq.size() != 1) {
				Node first = pq.remove(), second = pq.remove();
				Node temp = new Node('\0', first.cost + second.cost);
				temp.left = first;
				temp.right = second;
				pq.offer(temp);
			}

			Node root = pq.remove();
			initEncoderDecoder(root, "");
            this.encoded = encode(key);
            this.decoded = decode(this.encoded);
		}

		private void initEncoderDecoder(Node root, String key) {
			if (root.left == null && root.right == null) {
				encoder.put(root.data, key);
				decoder.put(key, root.data);
				return;
			}
			initEncoderDecoder(root.left, key + "0");
			initEncoderDecoder(root.right, key + "1");
		}

		private String encode(String key) {
		    StringBuilder encoded = new StringBuilder();
		    for (char c : key.toCharArray()) {
		        encoded.append(encoder.get(c));
		    }
		    return encoded.toString();
		}

		private String decode(String key) {
		    StringBuilder decodedS = new StringBuilder();
		    String window = "";
		    for (char c : key.toCharArray()) {
		        window += c;
		        if (decoder.containsKey(window)) {
		            decodedS.append(decoder.get(window));
		            window = "";
		        }
		    }
		    return decodedS.toString();
		}

		public String getEncodedString() {
		    return this.encoded;
		}

		public String getDecodedString() {
		    return this.decoded;
		}

		class Node implements Comparable<Node> {
			Node left, right;
			char data;
			int cost;

			Node(char data, int cost) {
				this.cost = cost;
				this.data = data;
				this.left = this.right = null;
			}

			@Override
			public int compareTo(Node key) {
				return this.cost - key.cost;
			}

			@Override 
			public String toString() {
			    return this.data + " " + this.cost;
			}
		}
	}
}
```

## Explanation

1. **Frequency Calculation**: The frequency of each character in the input string is calculated and stored in a `HashMap`.
2. **Huffman Tree Construction**: Nodes representing each character and its frequency are created and added to a priority queue. The tree is built by repeatedly merging the two nodes with the lowest frequencies until a single tree remains.
3. **Encoder/Decoder Initialization**: The tree is traversed to build the encoder and decoder maps, which map characters to binary strings and vice versa.
4. **Encoding**: The input string is encoded by replacing each character with its corresponding binary string from the encoder map.
5. **Decoding**: The encoded string is decoded by matching binary strings with characters from the decoder map.

This implementation demonstrates a practical application of Huffman Coding for data compression and decompression.

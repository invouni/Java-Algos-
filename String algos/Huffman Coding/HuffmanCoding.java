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

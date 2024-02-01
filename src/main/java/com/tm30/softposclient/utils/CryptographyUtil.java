package com.tm30.softposclient.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Arrays;

public class CryptographyUtil {
	public static final String CTMK = "3CDDE1CC6FDD225C9A8BC3EB065509A6";

	public
		enum MODE {
			ENCRYPT(0), DECRYPT(1);
			final int code;

			MODE(int code) {
				this.code = code;
			}
		}

		public static String encrypt(String plaintext, String rawkey) throws Exception {
			byte[] result = trip(plaintext.getBytes(), rawkey.getBytes(), MODE.ENCRYPT);
			return b2h(result);
		}

		public static String decrypt(String encrypted, String rawkey) throws Exception {
			StringBuilder res = new StringBuilder();

			for (byte b : trip(h2b(encrypted), rawkey.getBytes(), MODE.DECRYPT))
				res.append(String.format("%c", b));

			return res.toString();
		}

		private static SecretKey prepKey(byte[] key) throws Exception {
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			return skf.generateSecret(dks);
		}

		private static byte[] trip(byte[] input, byte[] key, MODE mode) throws Exception {
			int[][] process = {
					{Cipher.ENCRYPT_MODE, Cipher.DECRYPT_MODE, Cipher.ENCRYPT_MODE},  // encrypt
					{Cipher.DECRYPT_MODE, Cipher.ENCRYPT_MODE, Cipher.DECRYPT_MODE}}; // decrypt
			byte[] res = input;

			for (int i = 0; i < 3; i++)
				res = digest(res, Arrays.copyOfRange(key, 0, (i + 1) * 8), process[mode.code][i]);

			return res;
		}

		private static byte[] digest(byte[] plain, byte[] key, int mode) throws Exception {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(mode, prepKey(key));
			return cipher.doFinal(plain);
		}

	public static byte[] h2b(String hex)
	{
		if ((hex.length() & 0x01) == 0x01)
			throw new IllegalArgumentException();
		byte[] bytes = new byte[hex.length() / 2];
		for (int idx = 0; idx < bytes.length; ++idx)
		{
			int hi = Character.digit((int) hex.charAt(idx * 2), 16);
			int lo = Character.digit((int) hex.charAt(idx * 2 + 1), 16);
			if ((hi < 0) || (lo < 0))
				throw new IllegalArgumentException();
			bytes[idx] = (byte) ((hi << 4) | lo);
		}
		return bytes;
	}
	public static String b2h(byte[] bytes)
	{
		char[] hex = new char[bytes.length * 2];
		for (int idx = 0; idx < bytes.length; ++idx)
		{
			int hi = (bytes[idx] & 0xF0) >>> 4;
			int lo = (bytes[idx] & 0x0F);
			hex[idx * 2] = (char) (hi < 10 ? '0' + hi : 'A' - 10 + hi);
			hex[idx * 2 + 1] = (char) (lo < 10 ? '0' + lo : 'A' - 10 + lo);
		}
		return new String(hex);
	}

}

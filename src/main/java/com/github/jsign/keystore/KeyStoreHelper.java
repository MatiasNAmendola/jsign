package com.github.jsign.keystore;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class KeyStoreHelper {
	
	protected X509Certificate certificate;
	protected KeyStore keyStore;
	protected PrivateKey privateKey;
	protected Certificate[] certsChain;	
	
	public abstract String getType();
	
	public Certificate[] getCertsChain() {
		return certsChain;
	}

	public X509Certificate getCertificate() {
		return certificate;
	}

	public KeyStore getKeyStore() {
		return keyStore;
	}
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
		
	public static List<X509Certificate> getCertificatesAvailable(KeyStore keyStore) throws Exception {
		try {
			List<X509Certificate> certificates = new ArrayList<X509Certificate>();

			Enumeration<String> aliases = keyStore.aliases();

			while (aliases.hasMoreElements()) {
				
				String alias = (String) aliases.nextElement();

				if (keyStore.isKeyEntry(alias)) {
					certificates.add((X509Certificate) keyStore.getCertificate(alias));
				}
			}

			return certificates;
		}
		catch (KeyStoreException e) {
			throw new Exception("O KeyStore não foi inicializado corretamente!\n" + e);
		}
	}
}

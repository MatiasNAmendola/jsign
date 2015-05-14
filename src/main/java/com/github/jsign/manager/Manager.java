package com.github.jsign.manager;

public class Manager {

	private PKCS11Manager pkcs11Manager;
	private PKCS12Manager pkcs12Manager;
	private ConfigurationManager configurationManager;
	private MSCAPIManager mscapiManager;
		
	public Manager() {
		mscapiManager = new MSCAPIManager();
		pkcs11Manager = new PKCS11Manager();
		pkcs12Manager = new PKCS12Manager();
		configurationManager = new ConfigurationManager();
		configurationManager.setMSCAPIManager(mscapiManager);
		configurationManager.setPKCS11Manager(pkcs11Manager);
		configurationManager.setPKCS12Manager(pkcs12Manager);
	}

	public PKCS11Manager getPkcs11Manager() {
		return pkcs11Manager;
	}

	public PKCS12Manager getPkcs12Manager() {
		return pkcs12Manager;
	}

	public ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}

	public MSCAPIManager getMscapiManager() {
		return mscapiManager;
	}	
}

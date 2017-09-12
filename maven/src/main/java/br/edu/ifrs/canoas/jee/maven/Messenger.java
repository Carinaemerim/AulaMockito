package br.edu.ifrs.canoas.jee.maven;

public class Messenger {

	private TemplateEngine templateEngine;
	private MailServer mailServer;
	
	public Messenger(MailServer mailServer, TemplateEngine templateEngine){
		
		this.mailServer = mailServer;
		this.templateEngine = templateEngine;
	}
	public void sendMessage (Cliente cliente, Template template){
		
		String msg = templateEngine.prepareMessage(template, cliente);
		
		mailServer.send (cliente.getEmail(), msg);
	}
}

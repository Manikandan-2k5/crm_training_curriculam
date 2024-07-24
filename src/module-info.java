module crm_training_curriculam {
	requires java.instrument;
	requires jol.core;
	requires org.json;
	requires java.rmi;
	exports com.learn.java.intro;
	opens com.learn.java.intro to java.rmi;
}
package com.learn.java.intro;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMethodInvocationServer {
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(1289);
		CalculatorServer calculator = new CalculatorImpl();
		registry.bind("CalculatorServer", calculator);
	}
	
}

interface CalculatorServer extends Remote{
	
	public int add(int a, int b) throws RemoteException;
	
}

class CalculatorImpl extends UnicastRemoteObject implements CalculatorServer{

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		System.out.println("Method is called from Client.");
		return a+b;
	}
	
}

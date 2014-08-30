package com.decentralbank.decentralj.core;

import java.math.BigInteger;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.NetworkParameters;

/**
 * A Node's Pool Account for currency or smart contracts
 */
public class Account{
    
    /* A value equal to the number of transactions or contracts */
	private BigInteger nonce;
    /* total balance of bitcoin*/
    private BigInteger balance;
	//private eckey
    private ECKey ecKey;
	//address
	private Address address;
	//set to testnet for now
	private final NetworkParameters netParams = NetworkParameters.testNet();
	
	public Account() {
		this.ecKey = new ECKey();
	    this.address = this.ecKey.toAddress(netParams);	    
        System.out.println("testnet address:\n" + this.address);
	}

	public Account(ECKey ecKey) {
		this.ecKey = ecKey;
	}

	public Account(ECKey ecKey, BigInteger nonce, BigInteger balance) {
		this.ecKey = ecKey;
		this.nonce = nonce;
		this.balance = balance;
	}	

	public BigInteger getNonce() {
        return nonce;
    }
	
    public ECKey getECKey() {
    	
        return ecKey;
    
    }

	public Address getAddress() {
		
		return address;
	
	}

	public void setAddress(Address address) {
		
		this.address = address;
	
	}
	
    public BigInteger getBalance() {
    	
		if(balance.equals(BigInteger.ZERO)){
			return BigInteger.ZERO;
		}
		
		return balance;
	
	}

	public void setBalance(BigInteger balance) {
		
		this.balance = balance;
	
	}
}
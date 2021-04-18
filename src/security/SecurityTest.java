package security;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyPermission;

public class SecurityTest {
	
	private static final AccessControlContext NOPERMS_ACC ;
	 
	static {
	    Permissions perms = new Permissions();
	    ProtectionDomain[] pd = { new ProtectionDomain(null, perms) };
	    NOPERMS_ACC = new AccessControlContext(pd);
	}
	

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("line.separator"));
		String lineSeparator = java.security.AccessController.doPrivileged(
			    new java.security.PrivilegedAction<String>() {
			        public String run() {
			            return System.getProperty("line.separator");
			        }
			    }
			 );
		 System.out.println(lineSeparator);
		 
		 
		 AccessController.doPrivileged(
				   new PrivilegedAction<List<Integer>>() {
				      public List<Integer> run() {
				         return Collections.unmodifiableList(null);
				      }
				   });
		 
	}
	

	public static String getSecret(String host) {
	    Permission perm = getHostPermission(host); // line n1
	  
	   Map<String, String> distributedCache = new HashMap<String, String>();
		if (distributedCache.containsKey(host)) {           
	        return distributedCache.get(host); 
	    }
	    
	    AccessController.checkPermission(perm);     // line n2

	    PermissionCollection perms = perm.newPermissionCollection();
	    perms.add(perm);
	    
	    PrivilegedAction<String> pa = new PrivilegedAction<String>() {
	        public String run() {
	            return getSecretFromHost(host);
	        }

			private String getSecretFromHost(String host) {
				// TODO Auto-generated method stub
				return null;
			}
	    };

	    AccessControlContext acc = new AccessControlContext(
	        new ProtectionDomain[] { 
	            new ProtectionDomain(null, perms) 
	        }
	    );

	    String secret = AccessController.doPrivileged(pa, acc); // line n3

	    distributedCache.put(host, secret);
	    return secret;
	}


	private static Permission getHostPermission(String host) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	 private static Map<String, User> data = new HashMap<>();
	   public static SecretFile get(String key) {
	      var cacheRecord = data.get(key);
	      if (cacheRecord != null) {
	         // DON'T DO THIS!
	         return cacheRecord.getValue();
	      }
	       
	      final var permission 
	         = new PropertyPermission(key,"read");
	      AccessController.checkPermission(permission);
	 
	      final var permissions = permission.newPermissionCollection();
	      permissions.add(permission);
	      var secret = AccessController.doPrivileged(
	         new PrivilegedAction<SecretFile>() {
	            public SecretFile run() {
	               return new SecretFile();
	            }
	         }, new AccessControlContext(new ProtectionDomain[] {
	               new ProtectionDomain(null, permissions) }));
	      data.put(key, new User(secret, permission));
	      return secret;
	   }
}

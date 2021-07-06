# What
Delegate authentication to an external identity provider. This can simplify development, minimize the requirement for user administration, and improve the user experience of the application.

# Why
Users typically need to work with multiple applications provided and hosted by different organizations they have a business relationship with. These users might be required to use specific (and different) credentials for each one. This can:

    Cause a disjointed user experience. Users often forget sign-in credentials when they have many different ones.

    Expose security vulnerabilities. When a user leaves the company the account must immediately be deprovisioned. It's easy to overlook this in large organizations.

    Complicate user management. Administrators must manage credentials for all of the users, and perform additional tasks such as providing password reminders.

# How
Implement an authentication mechanism that can use federated identity. Separate user authentication from the application code, and delegate authentication to a trusted identity provider.

The figure illustrates the Federated Identity pattern when a client application needs to access a service that requires authentication. The authentication is performed by an IdP that works in concert with an STS. The IdP issues security tokens that provide information about the authenticated user. 

![picture 48](../../images/21b55175789dc4df114b3fc7a0da4bdd889f7ac5b1162c9fd5f6e7ffa85daff2.png)  

Federated authentication provides a standards-based solution to the issue of trusting identities across diverse domains, and can support single sign-on. It's becoming more common across all types of applications, especially cloud-hosted applications because it supports single sign-on without requiring a direct network connection to identity providers.

# When to use

  
# Example

# What

Deploy static content to a cloud-based storage service that can deliver them directly to the client. This can reduce the need for potentially expensive compute instances

# How
you can put some of an application's resources and static pages in a storage service. The storage service can serve requests for these resources, reducing load on the compute resources that handle other web requests. The cost for cloud-hosted storage is typically much less than for compute instances.

# When to use
This pattern is useful for:

    Minimizing the hosting cost for websites and applications that contain some static resources.

    Minimizing the hosting cost for websites that consist of only static content and resources. Depending on the capabilities of the hosting provider's storage system, it might be possible to entirely host a fully static website in a storage account.

    Exposing static resources and content for applications running in other hosting environments or on-premises servers.

    Locating content in more than one geographical area using a content delivery network that caches the contents of the storage account in multiple datacenters around the world.

    Monitoring costs and bandwidth usage. Using a separate storage account for some or all of the static content allows the costs to be more easily separated from hosting and runtime costs.

This pattern might not be useful in the following situations:

    The application needs to perform some processing on the static content before delivering it to the client. For example, it might be necessary to add a timestamp to a document.

    The volume of static content is very small. The overhead of retrieving this content from separate storage can outweigh the cost benefit of separating it out from the compute resource.

  
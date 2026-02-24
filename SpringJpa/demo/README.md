Cascading Means 
<h6>Cascading Means when we perform any operation in the parent then what will be the effect of it on child </h6>
<h6>Cascading are various Type </h6>
CascadingType.Persist: save operation
<br>
CascadingType.MERGE:Propagate merge(update) operation
CascadingType.REMOVE:Propagate remove(Delete) operation 
CascadingType.REFRESH:Propagate refresh operation 
CascadingType.DETACH:Propagate detach operation 
CascadingType.ALL: Propagate all operation (merge, remove , refresh , etch)

<h1>OrphanRemoval</h1>
<h6>when it Triggers:</h6>
<h5>For @OneToMany: when a entity is removed from the collection (eg.list.remove(),clear(),or reassing a new collection)</h5>
<h5>For @OneToOne: When the refrence is set to be null or replace with a new entity</h5>

<h1>Automation Delete</h1>
Orphaned entities will be remove or delete automatically  during the jpa flush or commit operation without needing explicts call to entity.remove()

<h1>Difference from CascadeType.Remove</h1>
<h5>CascadeType.remove : Delete child entities when parent is delete 
</h5>
<h5>orphanRemoval:true deletes child entiteis when they are not longer refrene by the parent entities </h5>

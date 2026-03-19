import mongoose from "mongoose";
import {beforeEach, describe,expect,test} from '@jest/globals'
import { 
            createPost,
            listPosts,
            listAllPosts,
            listPostsByAuthor,
            listPostsByTags,
            getPostById, 
            updatePost, 
            deletePost 

        } from "../services/posts.js";
import { Post } from "../db/models/post.js";
describe('creating posts',()=>{
    //first test case with all parameter
    test('with all parameters should succeed',async()=>{
        const post= {
            title:'Hello Mongoose',
            author:'Daniel Bug',
            contents:'This is a post stored in MongoDB Database',
            tags: ['mongoose', 'nodejs', 'express', 'Jest'],
        }
        const createdPost = await createPost(post)
        expect(createdPost._id).toBeInstanceOf(mongoose.Types.ObjectId)
        const foundPost = await Post.findById(createdPost._id)
        expect(foundPost).toEqual(expect.objectContaining(post));
        
        expect(foundPost.createdAt).toBeInstanceOf(Date)
        expect(foundPost.updatedAt).toBeInstanceOf(Date)
    })

//2nd test with title failed
    test('without title should fail',async()=>{
        const post={
            author:'daniel bugl',
            contents:'POST without title',
            tags:['empty']
        }
        try{
            await createPost(post)
        }catch(err){
            expect(err).toBeInstanceOf(mongoose.Error.ValidationError)
            expect(err.message).toContain('`title` is required')
        }
    })

    //3rd test with title only
    test('with minimum parameter',async()=>{
        const post={
            title:'This is a title'
        }
        const createdPost = await createPost(post)
        expect(createdPost._id).toBeInstanceOf(mongoose.Types.ObjectId);
    })
})

const samplePosts=[
    {title:'learning redux', author:"Daniel Bug",tags:['redux']},
    {title:'learning react', author:"Daniel Bug",tags:['react']},
    {title:'learning FWDW', author:"Daniel Bug",tags:['reactjs','nodejs']},
    {title:'learning PPWJ', author:"Ritesh Kumar Bug",tags:['javascript']},
]

let createdSamplePosts=[]
beforeEach(async ()=>{
    await Post.deleteMany({})//all old post aree going to be deleted
    createdSamplePosts = []
    for(const post of samplePosts){
        const createdPost=new Post(post)
        createdSamplePosts.push(await createdPost.save())
    }
}
)

describe('listing post',()=>{
    test('should return all post',async ()=>{
        const posts = await listAllPosts();
        expect(posts.length).toEqual(createdSamplePosts.length)
    })
    test('should return post sorted by createdAt date with descending order',async ()=>{
        const posts = await listAllPosts()
        const sortedSamplePosts=createdSamplePosts.sort(
            (a,b)=>b.createdAt-a.createdAt,
        )
        expect(posts.map((post)=>post.createdAt)).toEqual(sortedSamplePosts.map((post)=>post.createdAt))
    })
    test('should take into account sort options',async()=>{
        const posts=listAllPosts({
            sortBy:'updatedAt',
            sortOrder:'ascending'
        })
        const sortedSamplePosts=createdSamplePosts.sort((a,b)=>a.updatedAt-b.updatedAt,)
        expect((await posts).map((post)=>
            post.updatedAt)).toEqual(sortedSamplePosts.map((post)=>post.updatedAt))
    })
    test('should filter post by author',async()=>{
        const posts=await listPostsByAuthor('Daniel Bug')
        expect(posts.length).toBe(3)
    })
    test('should filter post by tag',async()=>{
        const posts=await listPostsByTags('nodejs')
        expect(posts.length).toBe(1)
    })
})
describe('getting a post',()=>{
    //test to return a full document
    test('should return the full document',async ()=>{
        const post=await getPostById(createdSamplePosts[0]._id)
        expect(post.toObject()).toEqual(createdSamplePosts[0].toObject())
    })
    //test will fail to get if id doesn't exist
    test('should fail if id does not exist',async ()=>{
        const post=await getPostById('000000000000000000000000')
        expect(post).toEqual(null)
    })
})
describe('updating posr',()=>{
    //updating a property 
    test('should update the specify properly',async ()=>{
        await updatePost(createdSamplePosts[0]._id,{
            author:'Ritesh Mohanty'
        })
        const updatedPost = await Post.findById(createdSamplePosts[0]._id)
        expect(updatedPost.author).toEqual('Ritesh Mohanty')
    })
    test('should not update other properties',async ()=>{
        await updatePost(createdSamplePosts[0]._id,{
            author:'Ritesh Mohanty'
        })
        const updatedPost = await Post.findById(createdSamplePosts[0]._id)
        expect(updatedPost.title).toEqual('learning redux')
    })
    test('should update the updated timestamp',async ()=>{
        await updatePost(createdSamplePosts[0]._id,{
            author:'Ritesh Mohanty'
        })
        const updatedPost = await Post.findById(createdSamplePosts[0]._id)
        expect(updatedPost.updatedAt.getTime()).toBeGreaterThan(createdSamplePosts[0].updatedAt.getTime())
    })
    test(`should fail if ID Doesn't exist'`,async ()=>{
        const post = await updatePost(`000000000000000000000000`,{
            author:'Ritesh Mohanty'
        })
        expect(post).toEqual(null)
    })
})
describe('deleting post',()=>{
    test('should remove post from the database',async ()=>{
        const result = await deletePost(createdSamplePosts[0]._id)
        expect(result.deletedCount).toEqual(1);
        const deletedPost = await Post.findById(createdSamplePosts[0]._id)
        expect(deletedPost).toEqual(null);
    })
    test('should fail if wrong id is given',async()=>{
        const result = await deletePost(`000000000000000000000000`)
        expect(result.deletedCount).toEqual(0);
    })
   
})
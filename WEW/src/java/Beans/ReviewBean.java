/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

public class ReviewBean {
    protected int reviewID;
    protected int review_customerID;
    protected int review_productID;
    protected String review;

    public String getReview() {
        return review;
    }

    public int getReviewID() {
        return reviewID;
    }

    public int getReview_customerID() {
        return review_customerID;
    }

    public int getReview_productID() {
        return review_productID;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public void setReview_customerID(int review_customerID) {
        this.review_customerID = review_customerID;
    }

    public void setReview_productID(int review_productID) {
        this.review_productID = review_productID;
    }
    
    
}

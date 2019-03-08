package com.example.ok.coba_crud;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class PadiAdapter extends RecyclerView.Adapter<PadiAdapter.MyViewHolder>{
    List<Padi> mPadiList;

    public PadiAdapter(List <Padi> PadiList) {
        mPadiList = PadiList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.padi_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
//        final MyViewHolder item = (MyViewHolder) holder;
//        final Padi padiCons = mPadiList.get(position);
//
//        item.mTextViewId.setText("Id =" + padiCons.getId());


        holder.mTextViewId.setText("Id = " + mPadiList.get(position).getId());
        holder.mTextLuasLahan.setText("Luas_lahan = " + mPadiList.get(position).getLuas_lahan());
        holder.mTextTglTanam.setText("Tgl_tanam = " + mPadiList.get(position).getTgl_tanam());
        holder.mTextTglPanen.setText("Tgl_siap_panen= " + mPadiList.get(position).getTgl_siap_panen());
        holder.mTextHasilPanen.setText("Hasil_panen = " + mPadiList.get(position).getHasil_panen());
        holder.mTextPemilik.setText("Pemilik = " + mPadiList.get(position).getPemilik());
        holder.mTextNik.setText("NIK = " + mPadiList.get(position).getNik());
        holder.mTextPekerja.setText("Pekerja = " + mPadiList.get(position).getPekerja());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mPadiList.get(position).getId());
                mIntent.putExtra("luas_lahan = ", mPadiList.get(position).getLuas_lahan());
                mIntent.putExtra("tgl_tanam = ", mPadiList.get(position).getTgl_tanam());
                mIntent.putExtra("tgl_siap_panen= " , mPadiList.get(position).getTgl_siap_panen());
                mIntent.putExtra("hasil_panen = ", mPadiList.get(position).getHasil_panen());
                mIntent.putExtra("pemilik = ", mPadiList.get(position).getPemilik());
                mIntent.putExtra("nik = ", mPadiList.get(position).getNik());
                mIntent.putExtra("pekerja = ", mPadiList.get(position).getPekerja());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPadiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextLuasLahan, mTextTglTanam, mTextTglPanen, mTextHasilPanen, mTextPemilik, mTextNik, mTextPekerja;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextLuasLahan = (TextView) itemView.findViewById(R.id.tvLuas);
            mTextTglTanam = (TextView) itemView.findViewById(R.id.tvTglTanam);
            mTextTglPanen = (TextView) itemView.findViewById(R.id.tvTglPanen);
            mTextHasilPanen = (TextView) itemView.findViewById(R.id.tvHasil);
            mTextPemilik = (TextView) itemView.findViewById(R.id.tvPemilik);
            mTextNik = (TextView) itemView.findViewById(R.id.tvNik);
            mTextPekerja = (TextView) itemView.findViewById(R.id.tvPekerja);
        }

    }
}
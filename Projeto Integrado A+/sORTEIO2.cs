using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class Sorteio2 : Form
    {
        public Sorteio2()
        {
            InitializeComponent();
        }
        
        private void BUTstar_Click(object sender, EventArgs e)
        {
            int contador = 0;

            Random rand = new Random();

            while (contador < 8)
            {
                int N = rand.Next(0, 99);
                TXTsortiados.Text = TXTsortiados.Text + " " + N;
                
                if(B10.Name == Convert.ToString(N))
                {
                    B10.Enabled = false;
                }
                if (B1.Name == Convert.ToString(N))
                {
                    B1.Enabled = false;
                }
                if (B2.Name == Convert.ToString(N))
                {
                    B2.Enabled = false;
                }
                if (B3.Name == Convert.ToString(N))
                {
                    B3.Enabled = false;
                }
                if (B4.Name == Convert.ToString(N))
                {
                    B4.Enabled = false;
                }
                contador++;
            }

        }

    }
}
